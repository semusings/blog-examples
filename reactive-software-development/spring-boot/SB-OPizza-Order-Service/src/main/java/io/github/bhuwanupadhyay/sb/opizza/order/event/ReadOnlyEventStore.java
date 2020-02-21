package io.github.bhuwanupadhyay.sb.opizza.order.event;

import io.github.bhuwanupadhyay.sb.opizza.shared.Entity;
import io.github.bhuwanupadhyay.sb.opizza.shared.Identifier;

public interface ReadOnlyEventStore {

    <ID extends Identifier, T extends Entity<ID>> T find(ID id, Class<T> klass);

}
