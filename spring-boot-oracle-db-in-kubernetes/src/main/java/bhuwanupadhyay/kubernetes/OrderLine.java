package bhuwanupadhyay.kubernetes;

import lombok.Getter;

@Getter
public class OrderLine {

    private String itemId;
    private Quantity quantity;

}
