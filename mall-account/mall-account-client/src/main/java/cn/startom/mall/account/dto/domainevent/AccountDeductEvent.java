package cn.startom.mall.account.dto.domainevent;

import com.alibaba.cola.event.DomainEventI;

import static cn.startom.mall.account.dto.domainevent.DomainEventConstant.CUSTOMER_CREATED_TOPIC;

/**
 *
 * @author Frank Zhang
 * @date 2019-01-04 10:32 AM
 */
public class AccountDeductEvent implements DomainEventI {

    private int accountId;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
