package cn.startom.mall.order.dubbo;

import cn.startom.mall.order.dto.OrderAddCmd;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface DubboTccOrderServiceI {

    @TwoPhaseBusinessAction(name = "DubboTccActionOrderCreate" , commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepareOrderCreate(BusinessActionContext actionContext,
                                        @BusinessActionContextParameter(paramName = "cmd") OrderAddCmd cmd);

    /**
     * Commit boolean.
     *
     * @param actionContext the action context
     * @return the boolean
     */
    public boolean commit(BusinessActionContext actionContext);

    /**
     * Rollback boolean.
     *
     * @param actionContext the action context
     * @return the boolean
     */
    public boolean rollback(BusinessActionContext actionContext);
}
