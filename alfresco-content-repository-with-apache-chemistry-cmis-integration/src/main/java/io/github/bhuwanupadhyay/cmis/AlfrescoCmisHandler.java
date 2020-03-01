package io.github.bhuwanupadhyay.cmis;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class AlfrescoCmisHandler implements CmisHandler {

    @Override
    public Mono<ServerResponse> listDocument(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> getDocument(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> createDocument(ServerRequest request) {
        return null;
    }
}
