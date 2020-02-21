package bhuwanupadhyay.stepfunctions;

import bhuwanupadhyay.stepfunctions.payload.InventoryCheck;
import bhuwanupadhyay.stepfunctions.payload.DeclineOrder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class DeclineOrderFunction implements RequestHandler<InventoryCheck, DeclineOrder> {

    @Override
    public DeclineOrder handleRequest(InventoryCheck input, Context context) {
        return new DeclineOrder(true, input.getProductId());
    }
}
