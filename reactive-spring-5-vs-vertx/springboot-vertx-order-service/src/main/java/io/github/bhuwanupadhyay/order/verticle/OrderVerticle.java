package io.github.bhuwanupadhyay.order.verticle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bhuwanupadhyay.order.domain.Order;
import io.github.bhuwanupadhyay.order.domain.OrderService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OrderVerticle extends AbstractVerticle {

    static final String GET_ORDERS = "get.orders";

    static final String POST_ORDERS = "post.orders";

    private final ObjectMapper mapper = Json.mapper;

    private final OrderService orderService;

    @Override
    public void start() throws Exception {
        super.start();
        EventBus bus = vertx.eventBus();
        bus.<String>consumer(POST_ORDERS).handler(createOrder(orderService));
        bus.<String>consumer(GET_ORDERS).handler(getOrders(orderService));
    }

    private Handler<Message<String>> createOrder(OrderService service) {
        return msg -> vertx.<String>executeBlocking(future -> {
            try {
                Order order = mapper.readValue(msg.body(), Order.class);
                future.complete(mapper.writeValueAsString(service.createOrder(order)));
            } catch (IOException e) {
                System.out.println("Failed to serialize result");
                future.fail(e);
            }
        }, result -> {
            if (result.succeeded()) {
                msg.reply(result.result());
            } else {
                msg.reply(result.cause().toString());
            }
        });
    }

    private Handler<Message<String>> getOrders(OrderService service) {
        return msg -> vertx.<String>executeBlocking(future -> {
            try {
                future.complete(mapper.writeValueAsString(service.getOrders()));
            } catch (JsonProcessingException e) {
                System.out.println("Failed to serialize result");
                future.fail(e);
            }
        }, result -> {
            if (result.succeeded()) {
                msg.reply(result.result());
            } else {
                msg.reply(result.cause().toString());
            }
        });
    }

}
