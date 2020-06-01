package cn.startom.mall.order.eventhandler;

import cn.startom.mall.order.dto.domainevent.DomainEventConstant;
import cn.startom.mall.order.dto.domainevent.OrderCreatedEvent;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * 处理领域事件
 *
 * @author frankzhang
 * @date 2019/04/09
 */
@EventHandler
public class OrderCreatedHandler implements EventHandlerI<Response, OrderCreatedEvent> {

    private Logger logger = LoggerFactory.getLogger(OrderCreatedHandler.class);
    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @Override
    public Response execute(OrderCreatedEvent event) {
        //订单创建成功事件
        logger.debug("订单创建事件");
        //推送到消息队列
        kafkaTemplate.send(DomainEventConstant.ORDER_CREATED_TOPIC,event);
        return Response.buildSuccess();
    }
}
