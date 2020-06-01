package cn.startom.mall.storage.service.dubbo;

import cn.startom.mall.storage.api.StorageServiceI;
import cn.startom.mall.storage.dto.GetStockByCodeQry;
import cn.startom.mall.storage.dto.StockDeductCmd;
import cn.startom.mall.storage.dto.StockDeductRefundCmd;
import cn.startom.mall.storage.dto.domainmodel.Storage;
import cn.startom.mall.storage.dubbo.DubboStockServiceI;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DubboStorageServiceImpl implements DubboStockServiceI {
    private final Logger logger= LoggerFactory.getLogger(DubboStockServiceI.class);

    @Autowired
    private StorageServiceI storageServiceI;

    @Override
    public Response deductStock(StockDeductCmd cmd) {
        return storageServiceI.deDuctStock(cmd);
    }

    @Override
    public SingleResponse<Storage> getStockByCode(GetStockByCodeQry qry) {
        return storageServiceI.getStockByCode(qry);
    }



}
