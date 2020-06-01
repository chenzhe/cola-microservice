package cn.startom.mall.account.eventhandler;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import cn.startom.mall.account.dto.domainevent.AccountDeductEvent;

/**
 * Handle customer created event
 *
 * @author frankzhang
 * @date 2019/04/09
 */
@EventHandler
public class AccountDeductHandler implements EventHandlerI<Response, AccountDeductEvent> {

    private Logger logger = LoggerFactory.getLogger(AccountDeductHandler.class);

    @Override
    public Response execute(AccountDeductEvent event) {
        logger.debug("Sync new customer to Search");
        logger.debug("Logging system operation for new customer");
        return Response.buildSuccess();
    }
}
