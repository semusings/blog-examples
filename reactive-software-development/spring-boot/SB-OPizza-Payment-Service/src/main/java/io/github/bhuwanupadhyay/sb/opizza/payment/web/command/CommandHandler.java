package io.github.bhuwanupadhyay.sb.opizza.payment.web.command;

import io.github.bhuwanupadhyay.sb.opizza.payment.domain.Payment;
import io.github.bhuwanupadhyay.sb.opizza.payment.domain.PaymentCommand.OrderPaymentCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface CommandHandler {

    Mono<ServerResponse> payOrder(ServerRequest request);

    @Getter
    class OrderPaymentRequest {

        private String name;

        private String orderId;

        public OrderPaymentCommand asCommand() {
            return new OrderPaymentCommand(this.name, this.orderId);
        }
    }

    @AllArgsConstructor
    class OrderPaymentResponse extends ResourceSupport {

        private String id;

        public OrderPaymentResponse(Payment payment) {

        }
    }


}
