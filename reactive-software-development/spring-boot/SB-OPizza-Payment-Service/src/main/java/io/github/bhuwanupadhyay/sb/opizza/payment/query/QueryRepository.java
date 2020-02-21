package io.github.bhuwanupadhyay.sb.opizza.payment.query;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QueryRepository {

    Mono<PaymentEntity> find(String id);

    Flux<PaymentEntity> findAll();

}
