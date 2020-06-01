package cn.startom.mall.order.executor;


import cn.startom.mall.account.dto.AccountDeductCmd;
import cn.startom.mall.account.dubbo.DubboAccountServiceI;
import cn.startom.mall.order.common.CommonConvertor;
import cn.startom.mall.order.domain.gateway.OrderGateWay;
import cn.startom.mall.order.dto.OrderAddCmd;
import cn.startom.mall.order.dto.domainmodel.Order;
import cn.startom.mall.order.repository.OrderDO;
import cn.startom.mall.storage.dto.StockDeductCmd;
import cn.startom.mall.storage.dubbo.DubboStockServiceI;
import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransaction;
import io.seata.tm.api.GlobalTransactionContext;
import org.apache.dubbo.config.annotation.Reference;
import org.omg.CORBA.TRANSACTION_MODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;

@Command
public class OrderAddCmdExe implements CommandExecutorI<Response, OrderAddCmd>{

    private final Logger logger= LoggerFactory.getLogger(OrderAddCmdExe.class);
    @Autowired
    private OrderGateWay orderGateWay;


    @Override
    @Transactional
    public Response execute(OrderAddCmd cmd)  {
        logger.info("订单全局事务id："+ RootContext.getXID());
        Order order= cmd.getOrderInfo();
        int result= orderGateWay.CreateOrder(order);
        if(result>0) {
            return Response.buildSuccess();
        }else
        {
            return Response.buildFailure("FAIL","创建订单失败！");
        }
    }

}
