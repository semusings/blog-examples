package io.github.bhuwanupadhyay.sb.opizza.payment.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface PaymentCommand {

    String getName();

    String getOrderId();

    @RequiredArgsConstructor
    @Getter
    class OrderPaymentCommand implements PaymentCommand {

        private final String name;

        private final String orderId;
    }

}
