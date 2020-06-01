package cn.startom.mall.storage.repository;

import cn.startom.mall.storage.common.CommonConvertor;
import cn.startom.mall.storage.domain.gateway.StorageGateway;

import cn.startom.mall.storage.domain.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StorageRepository implements StorageGateway {
    @Autowired
    private StorageMapper storageMapper;


    @Override
    public Storage getByByCode(String code) {
        StorageDO storageDO= storageMapper.getByCode(code);
        Storage storage=null;
        if(storageDO!=null)
            storage= CommonConvertor.convertTo(storageDO,Storage.class);

        return storage;
    }

    @Override
    public int updateStorage(cn.startom.mall.storage.dto.domainmodel.Storage storage) {
        StorageDO storageDO=CommonConvertor.convertTo(storage,StorageDO.class);
        return storageMapper.updateStorage(storageDO);
    }


}
