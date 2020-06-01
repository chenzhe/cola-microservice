package cn.startom.mall.account.executor.query;

import cn.startom.mall.account.domain.gateway.AccountGateway;
import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.QueryExecutorI;
import com.alibaba.cola.dto.MultiResponse;
import cn.startom.mall.account.dto.AccountByIdQry;
import cn.startom.mall.account.dto.domainmodel.Account;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Command
public class AccountByIdQryExe implements QueryExecutorI<SingleResponse<Account>, AccountByIdQry> {

    @Autowired
    private AccountGateway accountGateway;

    @Override
    public SingleResponse<Account> execute(AccountByIdQry cmd) {

        Account account= accountGateway.getByById(cmd.getUser_id());
        return SingleResponse.of(account);
    }
}
