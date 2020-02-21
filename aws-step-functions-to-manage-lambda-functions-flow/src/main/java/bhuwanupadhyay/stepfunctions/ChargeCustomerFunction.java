package bhuwanupadhyay.stepfunctions;

import bhuwanupadhyay.stepfunctions.payload.ChargeCustomer;
import bhuwanupadhyay.stepfunctions.payload.UpdateInventory;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ChargeCustomerFunction implements RequestHandler<UpdateInventory, ChargeCustomer> {

    @Override
    public ChargeCustomer handleRequest(UpdateInventory input, Context context) {
        return new ChargeCustomer(true, input.getProductId());
    }
}
