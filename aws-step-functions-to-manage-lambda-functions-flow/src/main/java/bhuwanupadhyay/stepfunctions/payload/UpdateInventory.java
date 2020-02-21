package bhuwanupadhyay.stepfunctions.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInventory {
    private boolean updateInventory;
    private Integer productId;
}
