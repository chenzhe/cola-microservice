package cn.startom.mall.storage.service.dubbo;

import cn.startom.mall.storage.api.StorageServiceI;
import cn.startom.mall.storage.dto.GetStockByCodeQry;
import cn.startom.mall.storage.dto.StockDeductCmd;
import cn.startom.mall.storage.dto.StockDeductRefundCmd;
import cn.startom.mall.storage.dto.domainmodel.Storage;
import cn.startom.mall.storage.dubbo.DubboStockServiceI;
import cn.startom.mall.storage.dubbo.DubboTccStockServiceI;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DubboTccStorageServiceImpl implements DubboTccStockServiceI {
    private final Logger logger= LoggerFactory.getLogger(DubboStockServiceI.class);

    @Autowired
    private StorageServiceI storageServiceI;

    /******************TCC 模式*******************/
    @Override
    public boolean prepareDeductStock(BusinessActionContext actionContext, StockDeductCmd cmd) {
        logger.info("库存预扣除,检查库存");
        GetStockByCodeQry qry=new GetStockByCodeQry();
         qry.setCode(cmd.getCode());
        SingleResponse<Storage> stock= storageServiceI.getStockByCode(qry);
        return stock.getData().getCount()>cmd.getStock();
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {

        JSONObject jsonObject= (JSONObject) actionContext.getActionContext("cmd");
        StockDeductCmd cmd=jsonObject.toJavaObject(StockDeductCmd.class);
        Response res= storageServiceI.deDuctStock(cmd);
        logger.info("库存实际扣除");
        return res.isSuccess();
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        JSONObject jsonObject= (JSONObject) actionContext.getActionContext("cmd");
        StockDeductCmd cmd=jsonObject.toJavaObject(StockDeductCmd.class);

        logger.info("库存预检查归还资源！");
        return true;
    }
}
