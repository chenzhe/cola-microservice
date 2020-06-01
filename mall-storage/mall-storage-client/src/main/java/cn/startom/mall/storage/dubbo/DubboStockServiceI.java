package cn.startom.mall.storage.dubbo;

import cn.startom.mall.storage.dto.GetStockByCodeQry;
import cn.startom.mall.storage.dto.StockDeductCmd;
import cn.startom.mall.storage.dto.domainmodel.Storage;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

public interface DubboStockServiceI {

    Response deductStock(StockDeductCmd cmd);
    SingleResponse<Storage> getStockByCode(GetStockByCodeQry qry);

}
