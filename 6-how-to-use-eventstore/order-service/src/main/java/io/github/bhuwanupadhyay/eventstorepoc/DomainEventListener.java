package io.github.bhuwanupadhyay.eventstorepoc;

import io.github.bhuwanupadhyay.eventstorepoc.domain.OrderPlaced;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DomainEventListener {

  @EventListener
  @SneakyThrows
  public void listen(OrderPlaced placed) {
    new EventStorePublisher().publishEvent(placed);
  }
}
