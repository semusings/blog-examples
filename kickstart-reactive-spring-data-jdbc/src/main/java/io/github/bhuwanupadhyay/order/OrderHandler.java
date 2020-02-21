package io.github.bhuwanupadhyay.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RequiredArgsConstructor
@Component
class OrderHandler {

    private final OrderRepository repository;

    Mono<ServerResponse> getOrders(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(repository.findAll(), Order.class);
    }

    Mono<ServerResponse> getByOrderId(ServerRequest request) {
        String orderId = request.pathVariable("orderId");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(repository.findById(orderId), Order.class);
    }

    Mono<ServerResponse> getByCustomerId(ServerRequest request) {
        String customerId = request.pathVariable("customerId");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(repository.findByCustomerId(customerId), Order.class);
    }
}
