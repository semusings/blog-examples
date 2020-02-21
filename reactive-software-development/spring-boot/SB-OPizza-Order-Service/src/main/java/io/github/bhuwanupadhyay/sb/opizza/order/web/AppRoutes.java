package io.github.bhuwanupadhyay.sb.opizza.order.web;

import io.github.bhuwanupadhyay.sb.opizza.order.web.command.CommandHandler;
import io.github.bhuwanupadhyay.sb.opizza.order.web.query.QueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class AppRoutes {

    private static final String ORDERS = "/orders";

    private static final String ORDERS_FIND_BY_ID = "/orders/{id}";

    private final CommandHandler command;

    private final QueryHandler query;

    @Bean
    public RouterFunction<ServerResponse> routes() {

        return route()
            .GET(ORDERS, accept(APPLICATION_JSON), query::findAll)
            .GET(ORDERS_FIND_BY_ID, accept(APPLICATION_JSON), query::findById)
            .POST(ORDERS, accept(APPLICATION_JSON), command::placeOrder)
            .build();

    }


}
