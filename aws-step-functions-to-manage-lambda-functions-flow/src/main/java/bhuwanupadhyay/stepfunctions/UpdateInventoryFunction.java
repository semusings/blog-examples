package bhuwanupadhyay.stepfunctions;

import bhuwanupadhyay.stepfunctions.payload.ProcessOrder;
import bhuwanupadhyay.stepfunctions.payload.UpdateInventory;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateInventoryFunction implements RequestHandler<ProcessOrder, UpdateInventory> {

    @Override
    public UpdateInventory handleRequest(ProcessOrder input, Context context) {
        return new UpdateInventory(true, input.getProductId());
    }
}
