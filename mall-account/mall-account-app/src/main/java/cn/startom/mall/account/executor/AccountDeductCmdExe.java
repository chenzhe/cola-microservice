package cn.startom.mall.account.executor;


import cn.startom.mall.account.domain.gateway.AccountGateway;
import cn.startom.mall.account.dto.domainmodel.Account;
import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import cn.startom.mall.account.dto.AccountDeductCmd;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Command
public class AccountDeductCmdExe implements CommandExecutorI<Response, AccountDeductCmd>{
    private final Logger logger= LoggerFactory.getLogger(AccountDeductCmdExe.class);
    @Autowired
    private AccountGateway accountGateway;

    @Override
    @Transactional
    public Response execute(AccountDeductCmd cmd) {
        logger.info("账号全局事务id："+ RootContext.getXID());
        Account account= accountGateway.getByById(cmd.getUser_id());
        account.Deduct(cmd.getMoney());
        int result= accountGateway.updateAccount(account);
        if(result>0)
            return Response.buildSuccess();
        else
            return Response.buildFailure("FAIL","账户扣除失败");
    }

}
