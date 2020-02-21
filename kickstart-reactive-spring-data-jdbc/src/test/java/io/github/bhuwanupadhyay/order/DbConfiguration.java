package io.github.bhuwanupadhyay.order;

import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
class DbConfiguration {

    private PostgreSQLContainer postgres = new PostgreSQLContainer();

    @PostConstruct
    void begin() {
        postgres.start();
        System.setProperty("postgres.host", postgres.getContainerIpAddress());
        System.setProperty("postgres.port", postgres.getFirstMappedPort().toString());
        System.setProperty("postgres.databaseName", postgres.getDatabaseName());
        System.setProperty("postgres.username", postgres.getUsername());
        System.setProperty("postgres.password", postgres.getPassword());
    }

    @PreDestroy
    void shutdown() {
        postgres.stop();
    }
}