package bhuwanupadhyay.stepfunctions.payload;


import lombok.Data;

@Data
public class OrderRequest {

    private Integer productId;
    private Integer quantity;
}
