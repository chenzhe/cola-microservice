package cn.startom.mall.storage.dto;

import com.alibaba.cola.dto.Query;
import lombok.Data;

@Data
public class GetStockByCodeQry extends Query{
   private String code;
}
