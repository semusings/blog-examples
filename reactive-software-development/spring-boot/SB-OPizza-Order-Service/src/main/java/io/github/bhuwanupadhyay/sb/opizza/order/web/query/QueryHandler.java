package io.github.bhuwanupadhyay.sb.opizza.order.web.query;

import io.github.bhuwanupadhyay.sb.opizza.order.query.OrderData;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface QueryHandler {

    Mono<ServerResponse> findAll(ServerRequest request);

    Mono<ServerResponse> findById(ServerRequest request);

    class OrderResponse extends ResourceSupport {

        private String id;

        private String name;

        public OrderResponse(OrderData entity) {
            this.id = entity.getId();
            this.name = entity.getName();
        }
    }


}
