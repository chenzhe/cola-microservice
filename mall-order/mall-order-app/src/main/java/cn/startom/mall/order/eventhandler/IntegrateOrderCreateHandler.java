package cn.startom.mall.order.eventhandler;

import cn.startom.mall.order.dto.domainevent.DomainEventConstant;
import cn.startom.mall.order.dto.domainevent.OrderCreatedEvent;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 领域集成事件，订阅跨领域事件的消息
 */
@Component
public class IntegrateOrderCreateHandler {
    private final Logger logger= LoggerFactory.getLogger(IntegrateOrderCreateHandler.class);

    @KafkaListener(topics= DomainEventConstant.ORDER_CREATED_TOPIC,groupId = "orderServiceGroup")
    public void orderCreateHandler(OrderCreatedEvent event){
        logger.info("订单创建事件消费,订单编号："+event.getId());
    }
}
