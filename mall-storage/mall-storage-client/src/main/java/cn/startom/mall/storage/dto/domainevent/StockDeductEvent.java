package cn.startom.mall.storage.dto.domainevent;

import com.alibaba.cola.event.DomainEventI;

import static cn.startom.mall.storage.dto.domainevent.DomainEventConstant.CUSTOMER_CREATED_TOPIC;

/**
 * CustomerCreatedEvent
 *
 * @author Frank Zhang
 * @date 2019-01-04 10:32 AM
 */
public class StockDeductEvent implements DomainEventI {

    private String commodit_code;


    public String getCommodit_code() {
        return commodit_code;
    }

    public void setCommodit_code(String commodit_code) {
        this.commodit_code = commodit_code;
    }
}
