package bhuwanupadhyay.stepfunctions;

import bhuwanupadhyay.stepfunctions.payload.ChargeCustomer;
import bhuwanupadhyay.stepfunctions.payload.ProcessOrder;
import bhuwanupadhyay.stepfunctions.payload.ShipOrder;
import bhuwanupadhyay.stepfunctions.payload.UpdateInventory;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ShipOrderFunction implements RequestHandler<ChargeCustomer, ShipOrder> {

    @Override
    public ShipOrder handleRequest(ChargeCustomer input, Context context) {
        return new ShipOrder(true, input.getProductId());
    }
}
