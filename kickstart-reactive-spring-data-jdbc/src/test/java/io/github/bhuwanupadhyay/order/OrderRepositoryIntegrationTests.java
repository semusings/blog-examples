package io.github.bhuwanupadhyay.order;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DbConfiguration.class, PostgresR2DBC.class})
public class OrderRepositoryIntegrationTests {

    @Qualifier("orderRepository")
    @Autowired
    OrderRepository orders;
    @Autowired
    DatabaseClient database;

    @Before
    public void setUp() {
        Hooks.onOperatorDebug();

        List<String> statements = Arrays.asList(
                "DROP TABLE IF EXISTS " + Order.TABLE + " ;",
                "CREATE TABLE " + Order.TABLE + " ( orderId VARCHAR(100) PRIMARY KEY , itemId VARCHAR(100) NOT NULL , customerId VARCHAR(100) NOT NULL);");

        statements.forEach(it -> database.execute()
                .sql(it)
                .fetch()
                .rowsUpdated()
                .as(StepVerifier::create)
                .verifyComplete());
    }

    @Test
    public void executesFindAll() {

        Order pizza1 = new Order(newId(), "PIZZA-1", "Bhuwan-1");
        Order pizza2 = new Order(newId(), "PIZZA-2", "Bhuwan-1");

        insertOrders(pizza1, pizza2);

        orders.findAll()
                .as(StepVerifier::create)
                .assertNext(pizza1::equals)
                .assertNext(pizza2::equals)
                .verifyComplete();
    }

    @Test
    public void executesAnnotatedQuery() {

        Order pizza1 = new Order(newId(), "PIZZA-1", "Bhuwan-1");
        Order pizza2 = new Order(newId(), "PIZZA-2", "Bhuwan-2");

        insertOrders(pizza1, pizza2);

        orders.findByCustomerId("Bhuwan-1")
                .as(StepVerifier::create)
                .assertNext(pizza1::equals)
                .verifyComplete();
    }

    private void insertOrders(Order... orders) {
        this.orders.saveAll(Arrays.asList(orders))
                .as(StepVerifier::create)
                .expectNextCount(2)
                .verifyComplete();
    }

    @NotNull
    private String newId() {
        return UUID.randomUUID().toString();
    }
}