package cn.startom.mall.account.executor;

import cn.startom.mall.account.domain.gateway.AccountGateway;
import cn.startom.mall.account.dto.AccountDeductRefundCmd;
import cn.startom.mall.account.dto.domainmodel.Account;
import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Command
public class AccountDeductRefundCmdExe implements CommandExecutorI<Response, AccountDeductRefundCmd> {
    @Autowired
    private AccountGateway accountGateway;
    @Override
    @Transactional
    public Response execute(AccountDeductRefundCmd cmd) {
        Account account= accountGateway.getByById(cmd.getUser_id());
        account.addMoney(cmd.getMoney());
        int result= accountGateway.updateAccount(account);
        return Response.buildSuccess();
    }
}
