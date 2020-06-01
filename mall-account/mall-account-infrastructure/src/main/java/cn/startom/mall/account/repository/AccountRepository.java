package cn.startom.mall.account.repository;

import cn.startom.mall.account.common.CommonConvertor;
import cn.startom.mall.account.domain.gateway.AccountGateway;

import cn.startom.mall.account.dto.domainmodel.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRepository implements AccountGateway {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getByById(String userId) {
        AccountDO accountDO= accountMapper.getById(userId);
        Account account= null;
        if(accountDO!=null)
            account=CommonConvertor.convertTo(accountDO,Account.class);
        return account;
    }

    @Override
    public int updateAccount(Account account) {
        return accountMapper.updateAccount(account);
    }
}
