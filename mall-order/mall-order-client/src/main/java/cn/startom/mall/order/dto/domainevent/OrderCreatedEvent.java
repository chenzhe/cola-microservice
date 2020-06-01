package cn.startom.mall.order.dto.domainevent;

import com.alibaba.cola.event.DomainEventI;
/**
 * CustomerCreatedEvent
 *
 * @author Frank Zhang
 * @date 2019-01-04 10:32 AM
 */
public class OrderCreatedEvent implements DomainEventI {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
