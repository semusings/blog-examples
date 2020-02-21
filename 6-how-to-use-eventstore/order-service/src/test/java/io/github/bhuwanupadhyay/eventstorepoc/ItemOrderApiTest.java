package io.github.bhuwanupadhyay.eventstorepoc;

import io.github.bhuwanupadhyay.eventstorepoc.domain.ItemOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(
    classes = OrderServiceApp.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ItemOrderApiTest {

  @Autowired private TestRestTemplate rest;

  @Test
  public void placeOrder() {
    OrderPlaceCommand command = new OrderPlaceCommand();
    command.setFirstName("Shekhar");
    command.setLastName("Rai");
    command.setLocation("Bhaisipati");

    ResponseEntity<ItemOrder> response = rest.postForEntity("/orders", command, ItemOrder.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());
  }
}
