package cn.startom.mall.order.repository;

import lombok.Data;

@Data
public class OrderDO {
    private int id;
    private String user_id;
    private String commodity_code;
    private int count;
    private int money;
}
