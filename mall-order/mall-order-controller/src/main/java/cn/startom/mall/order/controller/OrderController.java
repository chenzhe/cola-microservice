package cn.startom.mall.order.controller;

import cn.startom.mall.order.api.OrderServiceI;
import cn.startom.mall.order.dto.OrderAddCmd;
import cn.startom.mall.order.dto.OrderInfoByIdQry;
import cn.startom.mall.order.dto.domainmodel.Order;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "物料接口")
public class OrderController {

    @Autowired
    private OrderServiceI orderService;

    @GetMapping(value = "/order")
    @ApiOperation("查询订单根据订单ID")
    public SingleResponse<Order> getOrderById(@RequestParam int id){
        OrderInfoByIdQry qry = new OrderInfoByIdQry();
        qry.setId(id);
        return orderService.getOrderById(qry);
    }

    @PostMapping(value = "/order")
    @ApiOperation("创建订单")
    public Response orderCreate(@RequestBody OrderAddCmd orderAddCmd){
        return orderService.orderCreate(orderAddCmd);
    }

    @PostMapping(value = "/orderTcc")
    @ApiOperation("创建订单TCC,没有测试成功")
    public Response orderCreateTcc(@RequestBody OrderAddCmd orderAddCmd){
        return orderService.orderCreateTcc(orderAddCmd);
    }
}
