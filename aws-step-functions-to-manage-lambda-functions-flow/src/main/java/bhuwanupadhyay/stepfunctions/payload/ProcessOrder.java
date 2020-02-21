package bhuwanupadhyay.stepfunctions.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessOrder {

    private boolean processOrder;
    private Integer productId;

}
