package io.github.bhuwanupadhyay.sb.opizza.order.domain;

import io.github.bhuwanupadhyay.sb.opizza.shared.Asserts;
import io.github.bhuwanupadhyay.sb.opizza.shared.Identifier;

public class OrderId implements Identifier<String> {

    static final String MISSING_ORDER_ID = "missing order id";

    private final String id;

    public OrderId(String id) {
        Asserts.notEmpty(id, MISSING_ORDER_ID);
        this.id = id;
    }

    public String value() {
        return id;
    }

}
