package cn.startom.mall.storage.controller;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import cn.startom.mall.storage.api.StorageServiceI;
import cn.startom.mall.storage.dto.StockDeductCmd;
import cn.startom.mall.storage.dto.GetStockByCodeQry;
import cn.startom.mall.storage.dto.domainmodel.Storage;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private StorageServiceI storageServiceI;

    @GetMapping(value = "/customer")
    public SingleResponse<Storage> listCustomerByName(@RequestParam String code){
        GetStockByCodeQry qry = new GetStockByCodeQry();
        qry.setCode(code);
        return storageServiceI.getStockByCode(qry);
    }

}
