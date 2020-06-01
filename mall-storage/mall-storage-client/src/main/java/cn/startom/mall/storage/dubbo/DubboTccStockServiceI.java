package cn.startom.mall.storage.dubbo;

import cn.startom.mall.storage.dto.StockDeductCmd;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
@LocalTCC
public interface DubboTccStockServiceI {
    /*****************************TCC 模式*************************************/
    @TwoPhaseBusinessAction(name = "DubboTccActionStock" , commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepareDeductStock(BusinessActionContext actionContext,
                                      @BusinessActionContextParameter(paramName = "cmd") StockDeductCmd cmd);

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
