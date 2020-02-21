package io.github.bhuwanupadhyay.sb.opizza.order.query;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QueryRepository {

    Mono<OrderData> find(String id);

    Flux<OrderData> findAll();

}
