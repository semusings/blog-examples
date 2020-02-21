package io.github.bhuwanupadhyay.eventstorepoc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class OrderPlaced extends DomainEvent {

  private String orderId;
  private Name customerName;
  private DeliveryAddress deliveryAddress;

  public OrderPlaced(String orderId, Name customerName, DeliveryAddress address) {
    super(UUID.randomUUID().toString(), OrderPlaced.class.getName());
    this.orderId = orderId;
    this.customerName = customerName;
    this.deliveryAddress = address;
  }
}
