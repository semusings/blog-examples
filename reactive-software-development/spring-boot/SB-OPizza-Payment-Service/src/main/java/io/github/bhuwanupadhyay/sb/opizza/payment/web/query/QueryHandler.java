package io.github.bhuwanupadhyay.sb.opizza.payment.web.query;

import io.github.bhuwanupadhyay.sb.opizza.payment.query.PaymentEntity;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface QueryHandler {

    Mono<ServerResponse> findAll(ServerRequest request);

    Mono<ServerResponse> findById(ServerRequest request);

    class PaymentResponse extends ResourceSupport {

        private String id;

        private String name;

        public PaymentResponse(PaymentEntity entity) {
            this.id = entity.getId();
            this.name = entity.getName();
        }

    }


}
