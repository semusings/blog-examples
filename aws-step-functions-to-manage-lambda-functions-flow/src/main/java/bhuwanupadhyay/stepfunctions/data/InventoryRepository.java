package bhuwanupadhyay.stepfunctions.data;

public class InventoryRepository {

    public boolean doesExists(Integer productId, Integer quantity) {
        return quantity < 5;
    }

}
