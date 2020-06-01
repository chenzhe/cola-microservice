package cn.startom.mall.order.service;

import cn.startom.mall.account.dto.AccountDeductCmd;
import cn.startom.mall.account.dubbo.DubboAccountServiceI;
import cn.startom.mall.account.dubbo.DubboTccAccountServiceI;
import cn.startom.mall.order.api.OrderServiceI;
import cn.startom.mall.order.dto.OrderAddCmd;
import cn.startom.mall.order.dto.OrderInfoByIdQry;
import cn.startom.mall.order.dto.domainmodel.Order;
import cn.startom.mall.order.dubbo.DubboTccOrderServiceI;
import cn.startom.mall.storage.dto.StockDeductCmd;
import cn.startom.mall.storage.dubbo.DubboStockServiceI;
import cn.startom.mall.storage.dubbo.DubboTccStockServiceI;
import com.alibaba.cola.command.CommandBusI;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransaction;
import io.seata.tm.api.GlobalTransactionContext;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderServiceI {
    private final Logger logger=LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private CommandBusI commandBus;
    /****AT 模式****/
    @Reference
    private DubboAccountServiceI accountServiceI;
    @Reference
    private DubboStockServiceI stockServiceI;

    /******TCC 模式******/
    @Reference
    private DubboTccAccountServiceI accountTccServiceI;
    @Reference
    private DubboTccStockServiceI stockTccServiceI;
    @Reference
    private DubboTccOrderServiceI tccOrderServiceI;

    @Override
    public SingleResponse<Order> getOrderById(OrderInfoByIdQry qry) {
        return (SingleResponse<Order>) commandBus.send(qry);
    }

    @Override
    @GlobalTransactional
    public Response orderCreate(OrderAddCmd cmd) {
        //1.扣除账户余额
        AccountDeductCmd cmd1=new AccountDeductCmd();
        cmd1.setMoney(cmd.getOrderInfo().getMoney());
        cmd1.setUser_id(cmd.getOrderInfo().getUser_id());
        Response res1= accountServiceI.accountDeduct(cmd1);
        //2.扣除库存
        StockDeductCmd stockDeductCmd=new StockDeductCmd();
        stockDeductCmd.setCode(cmd.getOrderInfo().getCommodity_code());
        stockDeductCmd.setStock(cmd.getOrderInfo().getCount());
        Response res2=stockServiceI.deductStock(stockDeductCmd);
        if(!res1.isSuccess()||!res2.isSuccess()) {
            //抛异常可以全局回滚
            throw new IllegalStateException("扣库存或扣余额失败！");
        }
        //3.创建订单
        Response res= commandBus.send(cmd);
        if(!res.isSuccess()) {
            //业务判断是否手工回滚全局事务
            try {

                GlobalTransaction transaction = GlobalTransactionContext.reload(RootContext.getXID());
                if (transaction != null)
                    transaction.rollback();
            } catch (TransactionException ex) {
                logger.error(ex.getMessage());
            }
        }
        return res;
    }

    @Override
    @GlobalTransactional
    public Response orderCreateTcc(OrderAddCmd cmd) {
        //1.扣除账户余额
        AccountDeductCmd cmd1=new AccountDeductCmd();
        cmd1.setMoney(cmd.getOrderInfo().getMoney());
        cmd1.setUser_id(cmd.getOrderInfo().getUser_id());
        boolean accountOk= accountTccServiceI.prepareAccountDeduct(null,cmd1);
        //2.扣除库存
        StockDeductCmd stockDeductCmd=new StockDeductCmd();
        stockDeductCmd.setCode(cmd.getOrderInfo().getCommodity_code());
        stockDeductCmd.setStock(cmd.getOrderInfo().getCount());
        boolean storageOk =stockTccServiceI.prepareDeductStock(null,stockDeductCmd);
        if(!storageOk||!accountOk) {
            //抛异常可以全局回滚
            throw new IllegalStateException("扣库存或扣余额失败！");
        }
        //创建订单
        boolean orderCreateOk= tccOrderServiceI.prepareOrderCreate(null,cmd);
        if(orderCreateOk)
            return Response.buildSuccess();
        else {
            throw new IllegalStateException("订单创建失败！");
        }
    }
}
