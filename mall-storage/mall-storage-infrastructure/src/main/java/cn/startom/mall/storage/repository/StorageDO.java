package cn.startom.mall.storage.repository;

import lombok.Data;

@Data
public class StorageDO {
  private int id;
  private String commodity_code;
  private int count;
}
