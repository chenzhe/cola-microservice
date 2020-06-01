package cn.startom.mall.order.dto;


import com.alibaba.cola.dto.Query;
import lombok.Data;

@Data
public class OrderInfoByIdQry extends Query {
    private int id;
}
