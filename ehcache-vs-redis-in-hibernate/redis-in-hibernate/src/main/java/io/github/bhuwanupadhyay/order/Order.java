package io.github.bhuwanupadhyay.order;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Order.TABLE)
@Getter
public class Order {
    public static final String TABLE = "app_orders";
    @Id
    private String orderId;
    private String itemId;
    private String customerId;
}
