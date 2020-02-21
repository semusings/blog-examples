package io.github.bhuwanupadhyay.gridfs;

import com.progressoft.kryptonite.catalog.contracts.FileUploadMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@SpringBootApplication
@EnableBinding(Sink.class)
@RequiredArgsConstructor
public class GridFsContentRepositoryApplication {

    private final FileRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(GridFsContentRepositoryApplication.class, args);
    }

    @Bean
    public GridFsTemplate gridFsTemplate(MongoDbFactory factory, MongoConverter converter) {
        return new GridFsTemplate(factory, converter);
    }

    @StreamListener(value = Sink.INPUT)
    public void listenFileUploadMessage(FileUploadMessage message) {
        repository.store(message);
    }

}
