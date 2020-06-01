package cn.startom.mall.storage.dto.domainmodel;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Storage {
    private int id;
    private String commodity_code;
    private int count;

    public void deductStock(int stock) {
        if(this.count>stock)
            this.count-=stock;
        else{
            throw new IllegalArgumentException("库存不足！");
        }
    }

    public void addStock(int stock) {
        this.count+=stock;
    }
}
