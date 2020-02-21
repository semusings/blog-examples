package io.github.bhuwanupadhyay.sb.opizza.order.domain;

import io.github.bhuwanupadhyay.sb.opizza.order.OrderEvent.ItemAddedEvent;
import io.github.bhuwanupadhyay.sb.opizza.order.OrderEvent.OrderPlacedEvent;
import io.github.bhuwanupadhyay.sb.opizza.order.domain.OrderCommand.ItemAddCommand;
import io.github.bhuwanupadhyay.sb.opizza.order.domain.OrderCommand.OrderPlaceCommand;
import io.github.bhuwanupadhyay.sb.opizza.shared.Asserts;
import io.github.bhuwanupadhyay.sb.opizza.shared.Entity;
import io.github.bhuwanupadhyay.sb.opizza.shared.Identifier;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public final class OrderEntity extends Entity<OrderId> {

    public static final String MISSING_ORDER_NAME = "missing order name";

    private CustomerId customerId;

    private DeliveryAddress deliveryAddress;

    private String name;

    private List<OrderLine> orderLines = new ArrayList<>();

    private OrderStatus status;

    public OrderEntity(OrderPlaceCommand command) {

        String id = Identifier.newId();

        LOG.debug("Command: 'OrderPlaceCommand' received.");

        Asserts.notEmpty(command.getName(), MISSING_ORDER_NAME);

        LOG.debug("Queuing up a new 'OrderPlacedEvent' for order '{}'.", id);

        apply(new OrderPlacedEvent(command.getName(), id));

    }

    public void on(ItemAddCommand command) {

        LOG.debug("Command: 'ItemAddCommand' received.");

        Asserts.notEmpty(command.getItemId(), "missing item id");
        Asserts.isPositive(command.getQuantity(), "quantity should be non-negative");

        this.orderLines.add(OrderLine.create(command.getItemId(), command.getQuantity()));

        LOG.debug("Queuing up a new 'ItemAddedEvent' for order '{}'.", id);

        apply(new ItemAddedEvent(command.getItemId(), getId().value(), command.getQuantity()));

    }

    public enum OrderStatus {
        PLACED,
        IN_KITCHEN,
        PAID,
        ON_THE_WAY
    }

}
