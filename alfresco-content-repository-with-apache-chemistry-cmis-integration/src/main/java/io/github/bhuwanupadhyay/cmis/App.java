package io.github.bhuwanupadhyay.cmis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> documentRoutes(CmisHandler handler) {
        return route(GET("/documents/{id}").and(accept(APPLICATION_JSON)), handler::getDocument)
                .andRoute(GET("/documents").and(accept(APPLICATION_JSON)), handler::listDocument)
                .andRoute(POST("/documents").and(contentType(APPLICATION_OCTET_STREAM)), handler::createDocument);
    }

}
