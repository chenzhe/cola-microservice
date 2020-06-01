package cn.startom.mall.account.repository;

import cn.startom.mall.account.dto.domainmodel.Account;
import lombok.Data;

@Data
public class AccountDO {
  private int id;
  private String user_id;
  private int money;
}
