package io.github.bhuwanupadhyay.ordering;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class Order {

    private final String orderId;
    private final String customerId;

    public void pay(BigDecimal amount) {

    }

}
