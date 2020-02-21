package io.github.bhuwanupadhyay.sb.opizza.order;

import io.github.bhuwanupadhyay.sb.opizza.shared.DomainEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface OrderEvent extends DomainEvent {

    String getOrderId();

    @RequiredArgsConstructor
    @Getter
    class ItemAddedEvent implements OrderEvent {

        private final String itemId;

        private final String orderId;

        private final Integer quantity;
    }

    @RequiredArgsConstructor
    @Getter
    class OrderDeliveredEvent implements OrderEvent {

        private final String name;

        private final String orderId;
    }

    @RequiredArgsConstructor
    @Getter
    class OrderPaidEvent implements OrderEvent {

        private final String name;

        private final String orderId;

        private final String paymentId;
    }

    @RequiredArgsConstructor
    @Getter
    class OrderPlacedEvent implements OrderEvent {

        private final String name;

        private final String orderId;
    }

    @RequiredArgsConstructor
    @Getter
    class OrderReadyEvent implements OrderEvent {

        private final String name;

        private final String orderId;
    }


}
