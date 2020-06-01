package cn.startom.mall.storage.executor;

import cn.startom.mall.storage.domain.gateway.StorageGateway;
import cn.startom.mall.storage.dto.StockDeductRefundCmd;
import cn.startom.mall.storage.dto.domainmodel.Storage;
import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Command
public class StockDeductRefundCmdExe implements CommandExecutorI<Response, StockDeductRefundCmd> {
    @Autowired
    private StorageGateway storageGateway;
    @Override
    @Transactional
    public Response execute(StockDeductRefundCmd cmd) {
        Storage storage= storageGateway.getByByCode(cmd.getCode());
        storage.addStock(cmd.getStock());
        int result= storageGateway.updateStorage(storage);
        return Response.buildSuccess();
    }
}
