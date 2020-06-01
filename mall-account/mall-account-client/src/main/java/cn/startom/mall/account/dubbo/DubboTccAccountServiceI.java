package cn.startom.mall.account.dubbo;

import cn.startom.mall.account.dto.AccountDeductCmd;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface DubboTccAccountServiceI {
    /*****TCC 模式******/

    @TwoPhaseBusinessAction(name = "DubboTccActionAccount" , commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepareAccountDeduct(BusinessActionContext actionContext,
                                        @BusinessActionContextParameter(paramName = "cmd") AccountDeductCmd cmd);

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
