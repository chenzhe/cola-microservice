package cn.startom.mall.order.api;


import cn.startom.mall.order.dto.OrderAddCmd;
import cn.startom.mall.order.dto.OrderInfoByIdQry;
import cn.startom.mall.order.dto.domainmodel.Order;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;

/**
 * 订单接口
 */
public interface OrderServiceI {
    SingleResponse<Order> getOrderById(OrderInfoByIdQry qry);

    /**
     * AT 模式
     * @param cmd
     * @return
     */
    Response orderCreate(OrderAddCmd cmd);

    /**
     * tcc 模式
     * @param cmd
     * @return
     */
    Response orderCreateTcc(OrderAddCmd cmd);
}
