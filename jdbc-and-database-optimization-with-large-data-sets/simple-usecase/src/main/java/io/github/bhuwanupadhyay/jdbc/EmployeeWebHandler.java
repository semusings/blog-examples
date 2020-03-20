package io.github.bhuwanupadhyay.jdbc;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface EmployeeWebHandler {

    Mono<ServerResponse> listEmployee(ServerRequest request);

    Mono<ServerResponse> getEmployee(ServerRequest request);

    Mono<ServerResponse> createEmployee(ServerRequest request);

}
