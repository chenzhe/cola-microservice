package cn.startom.mall.order.dubbo;

import cn.startom.mall.order.dto.domainmodel.Order;
import com.alibaba.cola.dto.SingleResponse;

import javax.xml.ws.Response;

/**
 * 订单服务
 */
public interface DubboOrderServiceI {
    /**
     * 获取订单详情
     * @param orderId
     * @return
     */
    SingleResponse<Order> getOrderByID(int orderId);
}
