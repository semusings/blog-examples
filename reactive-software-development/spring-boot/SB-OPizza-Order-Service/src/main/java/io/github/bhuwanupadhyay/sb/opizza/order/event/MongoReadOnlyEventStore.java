package io.github.bhuwanupadhyay.sb.opizza.order.event;

import io.github.bhuwanupadhyay.sb.opizza.shared.Entity;
import io.github.bhuwanupadhyay.sb.opizza.shared.Identifier;
import org.springframework.stereotype.Component;

@Component
class MongoReadOnlyEventStore implements ReadOnlyEventStore {

    @Override
    public <ID extends Identifier, T extends Entity<ID>> T find(ID id) {
        return null;
    }

}
