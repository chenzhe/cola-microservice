package cn.startom.mall.storage.executor.query;

import cn.startom.mall.storage.domain.gateway.StorageGateway;
import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.QueryExecutorI;
import com.alibaba.cola.dto.MultiResponse;
import cn.startom.mall.storage.dto.GetStockByCodeQry;
import cn.startom.mall.storage.dto.domainmodel.Storage;
import com.alibaba.cola.dto.SingleResponse;
import org.apache.dubbo.config.spring.context.annotation.DubboConfigConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Command
public class GetStockByCodeQryExe implements QueryExecutorI<SingleResponse<Storage>, GetStockByCodeQry> {

    @Autowired
    private StorageGateway storageGateway;

    @Override
    public SingleResponse<Storage> execute(GetStockByCodeQry cmd) {
        Storage storage= storageGateway.getByByCode(cmd.getCode());
        return SingleResponse.of(storage);
    }
}
