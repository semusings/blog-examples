package io.github.bhuwanupadhyay.tutorial;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = {"customer", "deliveryAddress", "itemOrders"})
@EqualsAndHashCode(exclude = {"customer", "deliveryAddress", "itemOrders"})
class OrderLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private DeliveryAddress deliveryAddress;
    @OneToMany
    private Set<ItemOrder> itemOrders;

}

@Getter
@Setter
@Entity
@ToString(exclude = {"name", "phoneNo"})
@EqualsAndHashCode(exclude = {"name", "phoneNo"})
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String phoneNo;

}

@Getter
@Setter
@Entity
@ToString(exclude = {"addressLine"})
@EqualsAndHashCode(exclude = {"addressLine"})
class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String addressLine;
}

@Entity
@Getter
@Setter
@ToString(exclude = {"itemName"})
@EqualsAndHashCode(exclude = {"itemName"})
class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String itemName;
}

@Entity
@Getter
@Setter
@ToString(exclude = {"item", "quantity"})
@EqualsAndHashCode(exclude = {"item", "quantity"})
class ItemOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    @ManyToOne
    private Item item;
    private Integer quantity;
}