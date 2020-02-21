package io.github.bhuwanupadhyay.order.verticle;

import io.github.bhuwanupadhyay.order.domain.Order;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.springframework.stereotype.Component;

@Component
public class ServerVerticle extends AbstractVerticle {

    private static final String BASE_PATH = "/api/orders";

    @Override
    public void start() throws Exception {
        super.start();
        Router router = Router.router(vertx);
        router.route(BASE_PATH + "*").handler(BodyHandler.create());
        router.get(BASE_PATH).handler(this::getOrdersHandler);
        router.post(BASE_PATH).handler(this::createOrderHandler);
        vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", 8080));
    }

    private void createOrderHandler(RoutingContext rc) {
        vertx.eventBus()
            .<String>send(OrderVerticle.POST_ORDERS, rc.getBodyAsString(), result -> {
                if (result.succeeded()) {
                    rc.response()
                        .putHeader("content-type", "application/json")
                        .setStatusCode(200)
                        .end(result.result().body());
                } else {
                    rc.response()
                        .setStatusCode(500)
                        .end();
                }
            });
    }

    private void getOrdersHandler(RoutingContext routingContext) {
        vertx.eventBus()
            .<String>send(OrderVerticle.GET_ORDERS, "", result -> {
                if (result.succeeded()) {
                    routingContext.response()
                        .putHeader("content-type", "application/json")
                        .setStatusCode(200)
                        .end(result.result()
                            .body());
                } else {
                    routingContext.response()
                        .setStatusCode(500)
                        .end();
                }
            });
    }

}
