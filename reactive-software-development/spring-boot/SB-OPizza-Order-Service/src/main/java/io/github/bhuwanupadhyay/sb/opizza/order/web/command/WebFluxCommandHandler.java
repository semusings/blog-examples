package io.github.bhuwanupadhyay.sb.opizza.order.web.command;

import io.github.bhuwanupadhyay.sb.opizza.order.domain.OrderEntity;
import io.github.bhuwanupadhyay.sb.opizza.order.domain.OrderId;
import io.github.bhuwanupadhyay.sb.opizza.order.event.ReadOnlyEventStore;
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

    private final ReadOnlyEventStore store;

    @Override
    public Mono<ServerResponse> addItem(ServerRequest request) {

        OrderEntity entity = store.find(new OrderId(request.pathVariable("id")), OrderEntity.class);

        return ServerResponse
            .ok()
            .body(

                request.bodyToMono(ItemAddRequest.class)
                    .map(ItemAddRequest::asCommand)
                    .doOnNext(entity::on)
                    .doOnNext(ignored -> publisher.publish(entity.events()))
                    .map(ignored -> new OrderCommandResponse(entity))

                ,

                OrderCommandResponse.class

            );
    }

    @Override
    public Mono<ServerResponse> placeOrder(ServerRequest request) {

        return ServerResponse
            .ok()
            .body(

                request.bodyToMono(OrderPlaceRequest.class)
                    .map(OrderPlaceRequest::asCommand)
                    .map(OrderEntity::new)
                    .doOnNext(o -> publisher.publish(o.events()))
                    .map(OrderCommandResponse::new)

                , OrderCommandResponse.class

            );

    }
}
