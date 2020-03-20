package io.github.bhuwanupadhyay.jdbc;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class JdbcEmployeeWebHandler implements EmployeeWebHandler {

    /*
        - Using by pagination
     */
    @Override
    public Mono<ServerResponse> listEmployee(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> getEmployee(ServerRequest request) {
        final String employeeNo = request.pathVariable("employee_no");

        return null;
    }

    @Override
    public Mono<ServerResponse> createEmployee(ServerRequest request) {
        return null;
    }

}
