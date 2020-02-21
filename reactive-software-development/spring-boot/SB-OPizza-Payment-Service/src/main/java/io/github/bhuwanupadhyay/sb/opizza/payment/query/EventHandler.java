package io.github.bhuwanupadhyay.sb.opizza.payment.query;

import io.github.bhuwanupadhyay.sb.opizza.order.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static io.github.bhuwanupadhyay.sb.opizza.order.OrderEvent.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class EventHandler {

    private final JpaRepository repository;

    @EventListener
    public void on(OrderPaidEvent event) {

        LOG.info("PaymentPlacedEvent: [{}] '{}'", event.getId(), event.getName());

        repository.save(new PaymentEntity(event));

    }

}
