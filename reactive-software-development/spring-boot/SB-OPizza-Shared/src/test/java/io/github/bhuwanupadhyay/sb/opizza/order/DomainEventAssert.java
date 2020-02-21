package io.github.bhuwanupadhyay.sb.opizza.order;

import io.github.bhuwanupadhyay.sb.opizza.shared.DomainEvent;
import io.github.bhuwanupadhyay.sb.opizza.shared.Entity;
import io.github.bhuwanupadhyay.sb.opizza.shared.Identifier;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.util.List;

import static java.util.stream.Collectors.toList;


public class DomainEventAssert extends AbstractAssert<DomainEventAssert, List<DomainEvent>> {

    private DomainEventAssert(List<DomainEvent> domainEvents) {
        super(domainEvents, DomainEventAssert.class);
    }

    public static <T extends Identifier> DomainEventAssert from(Entity<T> entity) {
        return new DomainEventAssert(entity.events());
    }

    public DomainEventAssert hasEvents(Class<?>... classes) {

        List<Class<? extends DomainEvent>> list = this.actual.stream().map(DomainEvent::getClass).collect(toList());

        for (Class<?> klass : classes) {

            if (!list.contains(klass)) {
                Assertions.fail("domain event type [" + klass.getName() + "] not found");
            }

        }

        return this;

    }

    public DomainEventAssert isEmpty() {

        if (!this.actual.isEmpty()) {
            Assertions.fail("domain events are not empty");
        }

        return this;
    }


    public DomainEventAssert isNotEmpty() {

        if (this.actual.isEmpty()) {
            Assertions.fail("domain events are empty");
        }

        return this;
    }

}