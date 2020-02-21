package io.github.bhuwanupadhyay.springboot.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
