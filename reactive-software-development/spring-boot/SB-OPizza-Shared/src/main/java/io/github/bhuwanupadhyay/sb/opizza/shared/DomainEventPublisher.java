package io.github.bhuwanupadhyay.sb.opizza.shared;

import java.util.List;

@FunctionalInterface
public interface DomainEventPublisher {

    boolean publish(List<DomainEvent> events);

}
