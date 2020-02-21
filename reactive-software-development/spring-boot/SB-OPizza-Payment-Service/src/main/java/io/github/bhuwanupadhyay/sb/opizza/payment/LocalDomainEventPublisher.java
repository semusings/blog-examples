package io.github.bhuwanupadhyay.sb.opizza.payment;

import io.github.bhuwanupadhyay.sb.opizza.shared.DomainEvent;
import io.github.bhuwanupadhyay.sb.opizza.shared.DomainEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocalDomainEventPublisher implements DomainEventPublisher {

    private final ApplicationEventPublisher publisher;

    @Override
    public boolean publish(List<DomainEvent> events) {
        events.forEach(publisher::publishEvent);
        return true;
    }


}
