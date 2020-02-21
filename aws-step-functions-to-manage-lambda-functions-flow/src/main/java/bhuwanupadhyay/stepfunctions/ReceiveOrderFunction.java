package bhuwanupadhyay.stepfunctions;

import bhuwanupadhyay.stepfunctions.data.InventoryRepository;
import bhuwanupadhyay.stepfunctions.payload.InventoryCheck;
import bhuwanupadhyay.stepfunctions.payload.OrderRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ReceiveOrderFunction implements RequestHandler<OrderRequest, InventoryCheck> {

    private final InventoryRepository inventory = new InventoryRepository();

    @Override
    public InventoryCheck handleRequest(OrderRequest input, Context context) {
        Integer productId = input.getProductId();
        Integer quantity = input.getQuantity();
        return new InventoryCheck(inventory.doesExists(productId, quantity), productId);
    }
}
