package bhuwanupadhyay.stepfunctions.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderStatus {
    private boolean updateOrderStatus;
    private Integer productId;
}
