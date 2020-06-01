package cn.startom.mall.account.service;

import cn.startom.mall.account.dto.AccountDeductRefundCmd;
import com.alibaba.cola.command.CommandBusI;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import cn.startom.mall.account.api.AccountServiceI;
import cn.startom.mall.account.dto.AccountDeductCmd;
import cn.startom.mall.account.dto.AccountByIdQry;
import cn.startom.mall.account.dto.domainmodel.Account;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountServiceI {

    @Autowired
    private CommandBusI commandBus;

    @Override
    public Response accountDeduct(AccountDeductCmd accountDeductCmd) {
        return commandBus.send(accountDeductCmd);
    }

    @Override
    public SingleResponse<Account> getById(AccountByIdQry accountByIdQry) {
        return (SingleResponse<Account>)commandBus.send(accountByIdQry);
    }

    @Override
    public Response accountDeductRefund(AccountDeductRefundCmd cmd1) {
        return commandBus.send(cmd1);
    }
}
