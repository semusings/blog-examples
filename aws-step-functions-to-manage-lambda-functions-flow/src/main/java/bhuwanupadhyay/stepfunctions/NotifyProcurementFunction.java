package bhuwanupadhyay.stepfunctions;

import bhuwanupadhyay.stepfunctions.payload.InventoryCheck;
import bhuwanupadhyay.stepfunctions.payload.NotifyProcurement;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class NotifyProcurementFunction implements RequestHandler<InventoryCheck, NotifyProcurement> {

    @Override
    public NotifyProcurement handleRequest(InventoryCheck input, Context context) {
        return new NotifyProcurement(true, input.getProductId());
    }
}
