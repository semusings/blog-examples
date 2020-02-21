package io.github.bhuwanupadhyay.sb.opizza.order.domain;

import io.github.bhuwanupadhyay.sb.opizza.shared.Asserts;
import lombok.Value;

@Value
public class OrderLine {

    private ItemId itemId;

    private Integer quantity;

    public static OrderLine create(String itemId, Integer quantity) {
        Asserts.notEmpty(itemId, "missing item id");
        Asserts.notNull(quantity, "missing quantity");
        return new OrderLine(new ItemId(itemId), quantity);
    }

}
