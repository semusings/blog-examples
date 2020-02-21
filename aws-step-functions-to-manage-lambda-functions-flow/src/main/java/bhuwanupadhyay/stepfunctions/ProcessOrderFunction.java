package bhuwanupadhyay.stepfunctions;

import bhuwanupadhyay.stepfunctions.payload.InventoryCheck;
import bhuwanupadhyay.stepfunctions.payload.ProcessOrder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ProcessOrderFunction implements RequestHandler<InventoryCheck, ProcessOrder> {

    @Override
    public ProcessOrder handleRequest(InventoryCheck input, Context context) {
        return new ProcessOrder(true, input.getProductId());
    }

}
