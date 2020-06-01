package cn.startom.mall.order.service.dubbo;


import cn.startom.mall.account.dto.AccountDeductCmd;
import cn.startom.mall.order.dto.OrderAddCmd;
import cn.startom.mall.order.dubbo.DubboTccOrderServiceI;
import com.alibaba.cola.command.CommandBusI;
import com.alibaba.cola.dto.Response;
import com.alibaba.fastjson.JSONObject;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Slf4j
public class DubboTccOrderServiceImpl implements DubboTccOrderServiceI {

    @Autowired
    private CommandBusI commandBus;

    @Override
    public boolean prepareOrderCreate(BusinessActionContext actionContext, OrderAddCmd cmd) {
        log.info("订单创建预检查");
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        JSONObject jsonObject= (JSONObject) actionContext.getActionContext("cmd");

        OrderAddCmd cmd=jsonObject.toJavaObject(OrderAddCmd.class);
        Response res=commandBus.send(cmd);
        log.info("订单实际创建");
        return res.isSuccess();
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        log.info("订单创建失败回滚");
        return true;
    }
}
