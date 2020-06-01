package cn.startom.mall.storage.dto;

import com.alibaba.cola.dto.Command;
import cn.startom.mall.storage.dto.domainmodel.Storage;
import lombok.Data;

@Data
public class StockDeductCmd extends Command{

    private String code;
    private int stock;

}
