package io.github.bhuwanupadhyay.order.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_orders")
@Getter
public class Order {

    private String customerId;

    private String itemId;

    @Id
    private String orderId;
}