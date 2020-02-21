package io.github.bhuwanupadhyay.order;

import io.github.bhuwanupadhyay.order.domain.Order;
import io.vertx.core.json.Json;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootVertxOrderServiceApplicationTests {

    private static final String ENDPOINT = "http://localhost:8080/api/orders";

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    @SneakyThrows
    public void createOrder() {
        ResponseEntity<String> response = restTemplate.postForEntity(ENDPOINT, order("order.json"), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Order order = Json.mapper.readValue(response.getBody(), Order.class);
        assertEquals("1", order.getCustomerId());
        assertEquals("1", order.getItemId());
        assertEquals("1", order.getOrderId());
    }

    @Test
    public void getOrders() {
        restTemplate.postForEntity(ENDPOINT, order("order.json"), String.class);
        ResponseEntity<String> response = restTemplate.getForEntity(ENDPOINT, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @SneakyThrows
    private String order(String file) {
        InputStreamReader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(file));
        return FileCopyUtils.copyToString(reader);
    }
}
