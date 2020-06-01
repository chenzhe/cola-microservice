package cn.startom.mall.account.api;

import cn.startom.mall.account.dto.AccountDeductRefundCmd;
import com.alibaba.cola.dto.Response;
import cn.startom.mall.account.dto.AccountDeductCmd;
import cn.startom.mall.account.dto.AccountByIdQry;
import cn.startom.mall.account.dto.domainmodel.Account;
import com.alibaba.cola.dto.SingleResponse;

public interface AccountServiceI {

     Response accountDeduct(AccountDeductCmd customerAddCmd);

     SingleResponse<Account> getById(AccountByIdQry customerListByNameQry);

    Response accountDeductRefund(AccountDeductRefundCmd cmd1);
}
