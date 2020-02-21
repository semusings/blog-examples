package io.github.bhuwanupadhyay.sb.opizza.order.domain;

import io.github.bhuwanupadhyay.sb.opizza.order.DomainEventAssert;
import io.github.bhuwanupadhyay.sb.opizza.order.OrderEvent.OrderPlacedEvent;
import org.junit.jupiter.api.Test;

class OrderEntityUnitTests {

    private static final String NAME = "232";

    @Test
    void canApplyOrderPlacedEvent_whenReceivePlaceOrderCommand() {
        OrderEntity order = new OrderEntity(new OrderCommand.OrderPlaceCommand(NAME));

        DomainEventAssert.from(order)
            .isNotEmpty()
            .hasEvents(OrderPlacedEvent.class);
    }


}