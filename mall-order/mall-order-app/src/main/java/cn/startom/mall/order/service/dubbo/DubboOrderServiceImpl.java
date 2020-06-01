package cn.startom.mall.order.service.dubbo;

import cn.startom.mall.order.api.OrderServiceI;
import cn.startom.mall.order.dto.OrderInfoByIdQry;
import cn.startom.mall.order.dto.domainmodel.Order;
import cn.startom.mall.order.dubbo.DubboOrderServiceI;
import com.alibaba.cola.command.CommandBusI;
import com.alibaba.cola.dto.SingleResponse;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.xml.ws.Response;

@Service
public class DubboOrderServiceImpl implements DubboOrderServiceI {

    @Autowired
    private OrderServiceI orderServiceI;

    @Override
    public SingleResponse<Order> getOrderByID(int orderId) {
        OrderInfoByIdQry qry=new OrderInfoByIdQry();
        qry.setId(orderId);
        return orderServiceI.getOrderById(qry);
    }
}
