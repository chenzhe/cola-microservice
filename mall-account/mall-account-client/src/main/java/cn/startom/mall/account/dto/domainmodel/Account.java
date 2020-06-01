package cn.startom.mall.account.dto.domainmodel;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Account {
    private int id;
    private String user_id;
    private int money;

    public void Deduct(int money) {
        if(this.money<=money)
            throw new IllegalArgumentException("金额不足");
        this.money-=money;

    }

    public void addMoney(int money) {
        this.money+=money;
    }
}
