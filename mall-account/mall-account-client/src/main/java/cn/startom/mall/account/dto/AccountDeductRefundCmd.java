package cn.startom.mall.account.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

@Data
public class AccountDeductRefundCmd extends Command {
    private String user_id;
    private int money;
}
