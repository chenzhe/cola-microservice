package cn.startom.mall.order.repository;

import cn.startom.mall.order.common.CommonConvertor;
import cn.startom.mall.order.domain.gateway.OrderGateWay;
import cn.startom.mall.order.dto.domainevent.OrderCreatedEvent;
import cn.startom.mall.order.dto.domainmodel.Order;
import cn.startom.mall.order.message.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository implements OrderGateWay {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private DomainEventPublisher domainEventPublisher;

    @Override
    public Order getOrderById(int orderId) {
        OrderDO orderDO= orderMapper.getOrderById(orderId);
        Order order=null;
        if(orderDO!=null) {
            order = CommonConvertor.convertTo(orderDO, Order.class);
        }
        return order;
    }

    @Override
    public int CreateOrder(Order order) {
        OrderDO orderDO=CommonConvertor.convertTo(order,OrderDO.class);
        int result= orderMapper.addOrder(orderDO);
        OrderCreatedEvent event=new OrderCreatedEvent();
        event.setId(orderDO.getId());
        domainEventPublisher.publish(event);
        return result;
    }
}
