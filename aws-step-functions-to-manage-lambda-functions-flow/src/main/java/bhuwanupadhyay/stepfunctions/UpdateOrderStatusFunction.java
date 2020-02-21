package bhuwanupadhyay.stepfunctions;

import bhuwanupadhyay.stepfunctions.payload.SendNotification;
import bhuwanupadhyay.stepfunctions.payload.UpdateOrderStatus;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateOrderStatusFunction implements RequestHandler<SendNotification, UpdateOrderStatus> {

    @Override
    public UpdateOrderStatus handleRequest(SendNotification input, Context context) {
        return new UpdateOrderStatus(true, input.getProductId());
    }
}
