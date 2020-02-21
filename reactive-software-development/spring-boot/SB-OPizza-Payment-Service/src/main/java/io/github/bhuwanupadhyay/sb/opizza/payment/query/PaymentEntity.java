package io.github.bhuwanupadhyay.sb.opizza.payment.query;


import io.github.bhuwanupadhyay.sb.opizza.order.OrderEvent.OrderPaidEvent;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class PaymentEntity {

    @Id
    private String id;

    private String name;

    private String orderId;


    public PaymentEntity() {
    }

    public PaymentEntity(OrderPaidEvent event) {
        this.id = event.getPaymentId();
        this.orderId = event.getId();
        this.name = event.getName();
    }
}
