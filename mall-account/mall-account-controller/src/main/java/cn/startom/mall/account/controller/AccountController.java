package cn.startom.mall.account.controller;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import cn.startom.mall.account.api.AccountServiceI;
import cn.startom.mall.account.dto.AccountDeductCmd;
import cn.startom.mall.account.dto.AccountByIdQry;
import cn.startom.mall.account.dto.domainmodel.Account;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountServiceI accountServiceI;

    @GetMapping(value = "/customer")
    public SingleResponse<Account> getById(@RequestParam String id){
        AccountByIdQry qry = new AccountByIdQry();
        qry.setUser_id(id);
        return accountServiceI.getById(qry);
    }

}
