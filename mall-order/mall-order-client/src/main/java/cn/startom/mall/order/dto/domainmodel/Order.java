package cn.startom.mall.order.dto.domainmodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("订单")
public class Order {
    @ApiModelProperty("订单ID")
    private int id;
    @NotNull
    @ApiModelProperty("用户编号")
    private String user_id;
    @ApiModelProperty("订单产品编号")
    private String commodity_code;
    @ApiModelProperty("订单数量")
    private int count;
    @ApiModelProperty("订单金额")
    private int money;
}
