package io.github.bhuwanupadhyay.sb.opizza.payment.web.command;

import io.github.bhuwanupadhyay.sb.opizza.payment.domain.Payment;
import io.github.bhuwanupadhyay.sb.opizza.shared.DomainEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class WebFluxCommandHandler implements CommandHandler {

    private final DomainEventPublisher publisher;

    @Override
    public Mono<ServerResponse> payOrder(ServerRequest request) {

        return ServerResponse
            .ok()
            .body(

                request.bodyToMono(OrderPaymentRequest.class)
                    .map(OrderPaymentRequest::asCommand)
                    .map(Payment::new)
                    .doOnNext(o -> publisher.publish(o.events()))
                    .map(OrderPaymentResponse::new)

                , OrderPaymentResponse.class
            );

    }
}
