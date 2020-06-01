package cn.startom.mall.storage.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageMapper {

  public StorageDO getByCode(String code);
  int updateStorage(StorageDO storageDO);
}
