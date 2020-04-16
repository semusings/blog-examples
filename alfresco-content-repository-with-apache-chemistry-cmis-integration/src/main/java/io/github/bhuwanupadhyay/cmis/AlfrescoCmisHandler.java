package io.github.bhuwanupadhyay.cmis;

import lombok.SneakyThrows;
import org.apache.chemistry.opencmis.client.SessionFactoryFinder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.ObjectId;
import org.apache.chemistry.opencmis.client.api.QueryResult;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.runtime.ObjectIdImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.enums.CmisVersion;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.*;

import static io.github.bhuwanupadhyay.cmis.AppCfg.Cmis;
import static org.apache.chemistry.opencmis.client.util.ContentStreamUtils.createByteArrayContentStream;
import static org.apache.chemistry.opencmis.commons.enums.VersioningState.MAJOR;

/*
    http://docs.oasis-open.org/cmis/CMIS/v1.1/CMIS-v1.1.pdf
 */
@Component
@EnableConfigurationProperties(AppCfg.class)
public class AlfrescoCmisHandler implements CmisHandler {

    private final Session session;
    private final Cmis cmis;

    public AlfrescoCmisHandler(AppCfg appCfg) {
        this.cmis = appCfg.getCmis();
        this.session = cmisSession();
    }

    @Override
    public Mono<ServerResponse> listDocument(ServerRequest request) {
        ItemIterable<QueryResult> results = session.query("", false);

        if (results == null)
            return ServerResponse.ok().bodyValue(new DocumentList());

        ItemIterable<QueryResult> resultsPage = results.getPage();

        Iterator<QueryResult> iterator = results.iterator();

        while (iterator.hasNext()) {
            QueryResult result = iterator.next();

            result.getProperties()
        }

        Page<DocumentResponse> page = new PageImpl<DocumentResponse>();

        return null;
    }

    @Override
    public Mono<ServerResponse> getDocument(ServerRequest request) {
        return Optional.ofNullable(request.pathVariables().get("objectId"))
                .map(
                        id -> Optional.ofNullable(session.getObject(id))
                                .map(object -> ServerResponse.ok().build())
                                .orElseGet(() -> ServerResponse.notFound().build())
                ).orElseGet(() -> ServerResponse.notFound().build());
    }

    @Override
    public Mono<ServerResponse> createDocument(ServerRequest request) {
        return request.bodyToMono(ByteArrayResource.class)
                .flatMap(resource -> {
                    Map<String, String> props = new HashMap<>();
                    final String id = UUID.randomUUID().toString();
                    ObjectId objectId = session.createDocument(
                            props,
                            new ObjectIdImpl(id),
                            createByteArrayContentStream("file_" + id, resource.getByteArray()),
                            MAJOR
                    );
                    return ServerResponse.ok().bodyValue(new CreateDocumentResponse(objectId.getId()));
                });
    }

    @SneakyThrows
    private Session cmisSession() {
        Map<String, String> parameter = new HashMap<>();
        parameter.put(SessionParameter.USER, cmis.getUsername());
        parameter.put(SessionParameter.PASSWORD, cmis.getPassword());
        parameter.put(SessionParameter.BROWSER_URL, cmis.getApiUrl());
        parameter.put(SessionParameter.FORCE_CMIS_VERSION, CmisVersion.CMIS_1_1.value());
        parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
        return SessionFactoryFinder.find().createSession(parameter);
    }


}
