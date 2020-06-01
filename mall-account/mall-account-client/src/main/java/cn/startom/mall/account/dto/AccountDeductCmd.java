package cn.startom.mall.account.dto;

import com.alibaba.cola.dto.Command;
import cn.startom.mall.account.dto.domainmodel.Account;
import lombok.Data;

@Data
public class AccountDeductCmd extends Command{

    private String user_id;
    private int money;

}
