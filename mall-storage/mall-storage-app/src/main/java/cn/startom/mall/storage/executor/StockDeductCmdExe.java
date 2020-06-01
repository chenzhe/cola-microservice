package cn.startom.mall.storage.executor;


import cn.startom.mall.storage.domain.gateway.StorageGateway;
import cn.startom.mall.storage.dto.domainmodel.Storage;
import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import cn.startom.mall.storage.dto.StockDeductCmd;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Command
public class StockDeductCmdExe implements CommandExecutorI<Response, StockDeductCmd>{
    private final Logger logger= LoggerFactory.getLogger(StockDeductCmdExe.class);
    @Autowired
    private StorageGateway storageGateway;

    @Override
    @Transactional
    public Response execute(StockDeductCmd cmd) {
        logger.info("库存全局事务id："+ RootContext.getXID());
        Storage storage=storageGateway.getByByCode(cmd.getCode());
        storage.deductStock(cmd.getStock());
        int result=storageGateway.updateStorage(storage);
        if(result>0)
            return Response.buildSuccess();
        else
            return Response.buildFailure("FAIL","扣除库存失败");
    }

}
