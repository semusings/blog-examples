package io.github.bhuwanupadhyay.jdbc;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class JdbcEmployeeWebHandler implements EmployeeWebHandler {
    @Override
    public Mono<ServerResponse> listEmployee(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> getEmployee(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> createEmployee(ServerRequest request) {
        return null;
    }
}
