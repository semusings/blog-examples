package io.github.bhuwanupadhyay.sb.opizza.payment.web.query;

import io.github.bhuwanupadhyay.sb.opizza.payment.query.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class WebFluxQueryHandler implements QueryHandler {

    public static final String ID = "id";

    private final QueryRepository repository;

    @Override
    public Mono<ServerResponse> findAll(ServerRequest request) {

        return ServerResponse
            .ok()
            .body(

                repository.findAll().map(PaymentResponse::new)

                , PaymentResponse.class
            );

    }

    @Override
    public Mono<ServerResponse> findById(ServerRequest request) {

        return ServerResponse
            .ok()
            .body(

                repository.find(request.pathVariable(ID)).map(PaymentResponse::new)

                , PaymentResponse.class
            );

    }


}
