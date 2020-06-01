package cn.startom.mall.storage.eventhandler;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import cn.startom.mall.storage.dto.domainevent.StockDeductEvent;

/**
 * Handle customer created event
 *
 * @author frankzhang
 * @date 2019/04/09
 */
@EventHandler
public class StockDeductHandler implements EventHandlerI<Response, StockDeductEvent> {

    private Logger logger = LoggerFactory.getLogger(StockDeductHandler.class);

    @Override
    public Response execute(StockDeductEvent event) {
        logger.debug("Sync new customer to Search");
        logger.debug("Logging system operation for new customer");
        return Response.buildSuccess();
    }
}
