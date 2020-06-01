package cn.startom.mall.account.service.dubbo;

import cn.startom.mall.account.api.AccountServiceI;
import cn.startom.mall.account.common.CommonConvertor;
import cn.startom.mall.account.dto.AccountDeductCmd;
import cn.startom.mall.account.dto.AccountDeductRefundCmd;
import cn.startom.mall.account.dubbo.DubboAccountServiceI;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DubboAccountServiceImpl implements DubboAccountServiceI {
    private final Logger logger= LoggerFactory.getLogger(DubboAccountServiceImpl.class);
    @Autowired
    private AccountServiceI accountServiceI;

    @Override
    public Response accountDeduct(AccountDeductCmd cmd) {
        return accountServiceI.accountDeduct(cmd);
    }


}
