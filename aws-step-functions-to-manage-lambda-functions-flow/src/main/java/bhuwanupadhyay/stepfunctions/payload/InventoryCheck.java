package bhuwanupadhyay.stepfunctions.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryCheck {

    private boolean inventoryExits;
    private Integer productId;

}
