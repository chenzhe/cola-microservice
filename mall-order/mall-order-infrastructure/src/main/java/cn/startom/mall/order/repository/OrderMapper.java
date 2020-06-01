package cn.startom.mall.order.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    /**
     * 获取单个订单详情
     * @param id
     * @return
     */
    OrderDO getOrderById(@Param("id")int id);

    /**
     * 插入订单
     * @param orderDO
     * @return
     */
    int addOrder(OrderDO orderDO);
}
