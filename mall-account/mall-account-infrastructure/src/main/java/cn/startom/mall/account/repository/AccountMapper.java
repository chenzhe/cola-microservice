package cn.startom.mall.account.repository;

import cn.startom.mall.account.dto.domainmodel.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

  public AccountDO getById(@Param("userId") String userId);
  int updateAccount(Account account);
}
