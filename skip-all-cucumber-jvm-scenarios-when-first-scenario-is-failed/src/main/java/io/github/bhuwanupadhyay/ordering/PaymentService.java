package io.github.bhuwanupadhyay.ordering;

import java.math.BigDecimal;
import java.util.Objects;

public class PaymentService {

    public void pay(String orderId, BigDecimal amount) {
        Order order = OrderService.orders
                .stream()
                .filter(v -> Objects.equals(v.getOrderId(), orderId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order not found:" + orderId));
        order.pay(amount);
    }

}
