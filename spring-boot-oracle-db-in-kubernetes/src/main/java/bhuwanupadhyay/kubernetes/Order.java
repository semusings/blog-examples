package bhuwanupadhyay.kubernetes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "Orders")
@Entity
public class Order {
    @Id
    private String orderId;
    private LocalDateTime orderedAt;
    private DeliveryAddress deliveryAddress;
    private String customerNotes;
    private String customerId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Order(String orderId, String customerId, DeliveryAddress deliveryAddress) {
        this.orderId = orderId;
        this.deliveryAddress = deliveryAddress;
        this.customerId = customerId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
