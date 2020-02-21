package io.github.bhuwanupadhyay.sb.opizza.order.web.command;

import io.github.bhuwanupadhyay.sb.opizza.order.domain.OrderCommand;
import io.github.bhuwanupadhyay.sb.opizza.order.domain.OrderCommand.ItemAddCommand;
import io.github.bhuwanupadhyay.sb.opizza.order.domain.OrderEntity;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface CommandHandler {

    Mono<ServerResponse> addItem(ServerRequest request);

    Mono<ServerResponse> placeOrder(ServerRequest request);

    @Getter
    class ItemAddRequest {

        private String itemId;


        private Integer quantity;

        public final ItemAddCommand asCommand() {
            return new ItemAddCommand(this.getItemId(), this.getQuantity());
        }
    }

    @Getter
    class OrderPlaceRequest {

        private String name;

        public final OrderCommand.OrderPlaceCommand asCommand() {
            return new OrderCommand.OrderPlaceCommand(this.name);
        }
    }

    class OrderCommandResponse extends ResourceSupport {

        private String id;

        public OrderCommandResponse(OrderEntity order) {

        }

    }


}
