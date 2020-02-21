package io.github.bhuwanupadhyay.sb.opizza.order.query;


import io.github.bhuwanupadhyay.sb.opizza.order.OrderEvent.OrderPlacedEvent;
import io.github.bhuwanupadhyay.sb.opizza.order.domain.OrderEntity.OrderStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ORDERS")
public class OrderData {

    @Id
    private String id;

    private String name;

    private String status;

    public OrderData() {
    }

    public OrderData(OrderPlacedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.status = OrderStatus.PLACED.name();
    }
}
