package io.github.bhuwanupadhyay.sb.opizza.payment.domain;

import io.github.bhuwanupadhyay.sb.opizza.shared.Asserts;
import io.github.bhuwanupadhyay.sb.opizza.shared.Identifier;

public class PaymentId implements Identifier<String> {

    public static final String MISSING_PAYMENT_ID = "missing payment id";

    private final String id;

    public PaymentId(String id) {
        Asserts.notEmpty(id, MISSING_PAYMENT_ID);
        this.id = id;
    }

    public String value() {
        return id;
    }

}
