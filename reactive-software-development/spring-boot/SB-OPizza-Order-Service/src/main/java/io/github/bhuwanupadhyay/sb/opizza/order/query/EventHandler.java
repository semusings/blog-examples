package io.github.bhuwanupadhyay.sb.opizza.order.query;

import io.github.bhuwanupadhyay.sb.opizza.order.OrderEvent.OrderPaidEvent;
import io.github.bhuwanupadhyay.sb.opizza.order.OrderEvent.OrderPlacedEvent;
import io.github.bhuwanupadhyay.sb.opizza.order.domain.OrderEntity.OrderStatus;
import io.github.bhuwanupadhyay.sb.opizza.shared.OPizzaDataException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EventHandler {

    private final JpaRepository repository;

    @EventListener
    public void on(OrderPlacedEvent event) {

        LOG.info("OrderPlacedEvent: [{}] '{}'", event.getId(), event.getName());

        repository.save(new OrderData(event));

    }

    @EventListener
    public void on(OrderPaidEvent event) {

        String orderId = event.getId();

        LOG.info("OrderPaidEvent: [{}] '{}'", orderId, event.getName());

        OrderData entity = find(orderId);
        entity.setStatus(OrderStatus.PAID.name());

        repository.save(entity);

    }

    private OrderData find(String id) {
        return repository.findById(id).orElseThrow(() -> new OPizzaDataException("order not found [" + id + "]"));
    }

}
