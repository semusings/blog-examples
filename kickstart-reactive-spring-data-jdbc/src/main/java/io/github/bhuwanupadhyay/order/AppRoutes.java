package io.github.bhuwanupadhyay.order;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.TEXT_HTML;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class AppRoutes {

    private final OrderHandler handler;

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return nest(
                accept(TEXT_HTML),
                route(GET("/"), request -> ok().contentType(TEXT_HTML).render("index")))
                .andNest(path("/api/v1/orders").and(accept(MediaType.APPLICATION_JSON)),
                        route(GET("/"), handler::getOrders)
                                .andRoute(GET("/{orderId}"), handler::getByOrderId)
                                .andRoute(GET("/{customerId}"), handler::getByCustomerId)
                );
    }
}
