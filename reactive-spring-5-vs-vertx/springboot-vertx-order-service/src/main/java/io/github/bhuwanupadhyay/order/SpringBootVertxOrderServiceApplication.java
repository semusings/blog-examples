package io.github.bhuwanupadhyay.order;

import io.github.bhuwanupadhyay.order.verticle.OrderVerticle;
import io.github.bhuwanupadhyay.order.verticle.ServerVerticle;
import io.vertx.core.Vertx;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootVertxOrderServiceApplication {

    private final OrderVerticle orderVerticle;

    private final ServerVerticle serverVerticle;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootVertxOrderServiceApplication.class, args);
    }

    @PostConstruct
    public void deployVerticle() {
        final Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(serverVerticle);
        vertx.deployVerticle(orderVerticle);
    }
}
