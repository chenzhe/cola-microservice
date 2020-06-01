package cn.startom.mall.account.dto;

import com.alibaba.cola.dto.Query;
import lombok.Data;

@Data
public class AccountByIdQry extends Query{
   private String user_id;
}
