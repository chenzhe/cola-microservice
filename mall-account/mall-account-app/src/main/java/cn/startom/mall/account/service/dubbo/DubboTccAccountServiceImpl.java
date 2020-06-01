package cn.startom.mall.account.service.dubbo;

import cn.startom.mall.account.api.AccountServiceI;
import cn.startom.mall.account.common.CommonConvertor;
import cn.startom.mall.account.dto.AccountByIdQry;
import cn.startom.mall.account.dto.AccountDeductCmd;
import cn.startom.mall.account.dto.AccountDeductRefundCmd;
import cn.startom.mall.account.dto.domainmodel.Account;
import cn.startom.mall.account.dubbo.DubboTccAccountServiceI;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DubboTccAccountServiceImpl implements DubboTccAccountServiceI {
    private final Logger logger= LoggerFactory.getLogger(DubboTccAccountServiceImpl.class);
    @Autowired
    private AccountServiceI accountServiceI;

    @Override
    public boolean prepareAccountDeduct(BusinessActionContext actionContext, AccountDeductCmd cmd) {
        logger.info("账号预扣除,检查余额是否满足扣除");
        AccountByIdQry qry=new AccountByIdQry();
        qry.setUser_id(cmd.getUser_id());
        SingleResponse<Account> account= accountServiceI.getById(qry);
        return account.getData().getMoney()>cmd.getMoney();
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        logger.info("账号实际扣除");
        JSONObject jsonObject= (JSONObject) actionContext.getActionContext("cmd");

        AccountDeductCmd cmd=jsonObject.toJavaObject(AccountDeductCmd.class);

        Response res= accountServiceI.accountDeduct(cmd);
        return res.isSuccess();
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        JSONObject jsonObject= (JSONObject) actionContext.getActionContext("cmd");
        AccountDeductCmd cmd=jsonObject.toJavaObject(AccountDeductCmd.class);
        logger.info("账号资源预检查失败，归还资源");
        return true;
    }
}
