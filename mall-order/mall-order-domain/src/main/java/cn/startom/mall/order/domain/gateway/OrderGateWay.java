package cn.startom.mall.order.domain.gateway;

import cn.startom.mall.order.dto.domainmodel.Order;

public interface OrderGateWay {

    Order getOrderById(int orderId);

    int CreateOrder(Order order);
}
