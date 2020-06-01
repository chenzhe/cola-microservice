package cn.startom.mall.order.dto;

import cn.startom.mall.order.dto.domainmodel.Order;
import com.alibaba.cola.dto.Command;
import lombok.Data;

@Data
public class OrderAddCmd extends Command {
    private Order orderInfo;
}
