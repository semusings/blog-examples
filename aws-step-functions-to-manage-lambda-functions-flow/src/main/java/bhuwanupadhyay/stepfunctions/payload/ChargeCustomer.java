package bhuwanupadhyay.stepfunctions.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargeCustomer {
    private boolean chargeCustomer;
    private Integer productId;
}
