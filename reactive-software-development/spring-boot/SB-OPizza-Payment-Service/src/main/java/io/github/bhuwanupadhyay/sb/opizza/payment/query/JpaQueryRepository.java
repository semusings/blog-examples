package io.github.bhuwanupadhyay.sb.opizza.payment.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
class JpaQueryRepository implements QueryRepository {

    private final JpaRepository repository;

    @Override
    public Mono<PaymentEntity> find(String id) {
        return Mono.justOrEmpty(repository.findById(id));
    }

    @Override
    public Flux<PaymentEntity> findAll() {
        return Flux.fromIterable(repository.findAll());
    }

}
