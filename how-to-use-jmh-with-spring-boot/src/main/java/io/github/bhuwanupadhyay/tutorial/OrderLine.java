package io.github.bhuwanupadhyay.tutorial;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString(exclude = {"itemId", "addressLine", "quantity"})
@EqualsAndHashCode(exclude = {"itemId", "addressLine", "quantity"})
class OrderLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long itemId;
    private String addressLine;
    private Integer quantity;

}