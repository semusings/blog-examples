package io.github.bhuwanupadhyay.order;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;

@Configuration
class PostgresR2DBC {

    @Value("${postgres.host}")
    private String host;
    @Value("${postgres.port}")
    private Integer port;
    @Value("${postgres.databaseName}")
    private String databaseName;
    @Value("${postgres.username}")
    private String username;
    @Value("${postgres.password}")
    private String password;

    @Bean
    OrderRepository orderRepository(R2dbcRepositoryFactory factory) {
        return factory.getRepository(OrderRepository.class);
    }

    @Bean
    R2dbcRepositoryFactory repositoryFactory(DatabaseClient client) {

        RelationalMappingContext context = new RelationalMappingContext();
        context.afterPropertiesSet();

        return new R2dbcRepositoryFactory(client, context);
    }

    @Bean
    DatabaseClient databaseClient(ConnectionFactory factory) {

        return DatabaseClient.builder()
                .connectionFactory(factory)
                .build();
    }

    @Bean
    PostgresqlConnectionFactory connectionFactory() {

        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .database(databaseName)
                .username(username)
                .password(password)
                .build();

        return new PostgresqlConnectionFactory(config);
    }

}