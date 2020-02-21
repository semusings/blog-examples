package io.github.bhuwanupadhyay.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Order {

    static final String TABLE = "Orders";
    @Id
    private String orderId;
    private String itemId;
    private String customerId;
}
