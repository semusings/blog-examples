package io.github.bhuwanupadhyay.sb.opizza.payment.domain;

import io.github.bhuwanupadhyay.sb.opizza.order.OrderEvent.OrderPaidEvent;
import io.github.bhuwanupadhyay.sb.opizza.payment.domain.PaymentCommand.OrderPaymentCommand;
import io.github.bhuwanupadhyay.sb.opizza.shared.Asserts;
import io.github.bhuwanupadhyay.sb.opizza.shared.Entity;
import io.github.bhuwanupadhyay.sb.opizza.shared.Identifier;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public final class Payment extends Entity<PaymentId> {

    public static final String MISSING_ORDER_ID = "missing order id";

    public static final String MISSING_ORDER_NAME = "missing order name";

    private String name;

    private OrderId orderId;


    public Payment(OrderPaymentCommand command) {

        String id = Identifier.newId();

        LOG.debug("Command: 'OrderPaymentCommand' received.");

        Asserts.notEmpty(command.getOrderId(), MISSING_ORDER_ID);
        Asserts.notEmpty(command.getName(), MISSING_ORDER_NAME);

        LOG.debug("Queuing up a new 'PaymentPlacedEvent' for order '{}'.", command.getOrderId());

        apply(new OrderPaidEvent(id, command.getName(), command.getOrderId()));

    }


}
