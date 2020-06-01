package cn.startom.mall.account.dubbo;

import cn.startom.mall.account.dto.AccountDeductCmd;
import com.alibaba.cola.dto.Response;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * Dubbo 账号服务
 */
public interface DubboAccountServiceI {
    /**
     * 账号扣款
     * @param cmd
     * @return
     */
   Response accountDeduct(AccountDeductCmd cmd);



}
