package cn.startom.mall.storage.api;

import cn.startom.mall.storage.dto.StockDeductRefundCmd;
import com.alibaba.cola.dto.Response;
import cn.startom.mall.storage.dto.StockDeductCmd;
import cn.startom.mall.storage.dto.GetStockByCodeQry;
import cn.startom.mall.storage.dto.domainmodel.Storage;
import com.alibaba.cola.dto.SingleResponse;

public interface StorageServiceI {

    public Response deDuctStock(StockDeductCmd customerAddCmd);

    public SingleResponse<Storage> getStockByCode(GetStockByCodeQry customerListByNameQry);

    Response deDuctStockRollback(StockDeductRefundCmd cmd);
}
