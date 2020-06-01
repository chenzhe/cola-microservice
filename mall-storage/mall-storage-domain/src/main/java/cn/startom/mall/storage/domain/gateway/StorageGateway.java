package cn.startom.mall.storage.domain.gateway;


import cn.startom.mall.storage.dto.domainmodel.Storage;

public interface StorageGateway {

     Storage getByByCode(String code);
     int updateStorage(Storage storage);
}
