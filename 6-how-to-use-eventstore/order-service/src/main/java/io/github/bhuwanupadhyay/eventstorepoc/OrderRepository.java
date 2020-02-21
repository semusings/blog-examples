package io.github.bhuwanupadhyay.eventstorepoc;

import io.github.bhuwanupadhyay.eventstorepoc.domain.ItemOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<ItemOrder, String> {}
