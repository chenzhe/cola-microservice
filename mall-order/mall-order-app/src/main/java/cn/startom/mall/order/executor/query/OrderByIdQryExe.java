package cn.startom.mall.order.executor.query;

import cn.startom.mall.order.common.ErrCode;
import cn.startom.mall.order.domain.gateway.OrderGateWay;
import cn.startom.mall.order.dto.OrderInfoByIdQry;
import cn.startom.mall.order.dto.domainmodel.Order;
import cn.startom.mall.order.repository.OrderMapper;
import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.QueryExecutorI;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Command
public class OrderByIdQryExe
        implements QueryExecutorI<SingleResponse<Order>, OrderInfoByIdQry> {

    @Autowired
    private OrderGateWay orderGateWay;

    public SingleResponse<Order> execute(OrderInfoByIdQry cmd) {
        Order order= orderGateWay.getOrderById(cmd.getId());
        if(order==null)
            return SingleResponse.buildFailure(ErrCode.NOT_FOUND.getErrorCode(),String.format(ErrCode.NOT_FOUND.getErrMessage(),"订单"));
        return SingleResponse.of(order);
    }
}
