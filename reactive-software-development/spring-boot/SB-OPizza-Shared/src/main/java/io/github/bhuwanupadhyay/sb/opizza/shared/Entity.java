package io.github.bhuwanupadhyay.sb.opizza.shared;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @param <ID> identifier
 */
public abstract class Entity<ID extends Identifier> {

    private static final String MISSING_DOMAIN_EVENT = "missing domain event";

    private final List<DomainEvent> events = new LinkedList<>();

    protected ID id;

    public final List<DomainEvent> events() {
        return Collections.unmodifiableList(events);
    }

    public final ID getId() {
        return id;
    }

    protected final void apply(DomainEvent event) {
        Asserts.notNull(event, MISSING_DOMAIN_EVENT);
        events.add(event);
    }
}
