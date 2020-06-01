package cn.startom.mall.account.domain.gateway;

import cn.startom.mall.account.dto.domainmodel.Account;

public interface AccountGateway {
    Account getByById(String userId);
    int updateAccount(Account account);

}
