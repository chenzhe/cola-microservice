package cn.startom.mall.storage.service;

import cn.startom.mall.storage.dto.StockDeductRefundCmd;
import com.alibaba.cola.command.CommandBusI;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import cn.startom.mall.storage.api.StorageServiceI;
import cn.startom.mall.storage.dto.StockDeductCmd;
import cn.startom.mall.storage.dto.GetStockByCodeQry;
import cn.startom.mall.storage.dto.domainmodel.Storage;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StorageServiceImpl implements StorageServiceI {

    @Autowired
    private CommandBusI commandBus;


    @Override
    public Response deDuctStock(StockDeductCmd stockDeductCmd) {
        return commandBus.send(stockDeductCmd);
    }

    @Override
    public SingleResponse<Storage> getStockByCode(GetStockByCodeQry getStockByCodeQry) {
        return (SingleResponse<Storage>)commandBus.send(getStockByCodeQry);
    }

    @Override
    public Response deDuctStockRollback(StockDeductRefundCmd cmd) {
        return commandBus.send(cmd);
    }
}
