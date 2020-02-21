package io.github.bhuwanupadhyay.sb.opizza.order.domain;

import io.github.bhuwanupadhyay.sb.opizza.shared.Asserts;
import io.github.bhuwanupadhyay.sb.opizza.shared.Identifier;

public class CustomerId implements Identifier<String> {

    private static final String MISSING_CUSTOMER_ID = "missing customer id";

    private final String id;

    public CustomerId(String id) {
        Asserts.notEmpty(id, MISSING_CUSTOMER_ID);
        this.id = id;
    }

    @Override
    public String value() {
        return id;
    }
}
