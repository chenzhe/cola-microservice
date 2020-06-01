package cn.startom.mall.storage.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

@Data
public class StockDeductRefundCmd extends Command {
    private String code;
    private int stock;
}
