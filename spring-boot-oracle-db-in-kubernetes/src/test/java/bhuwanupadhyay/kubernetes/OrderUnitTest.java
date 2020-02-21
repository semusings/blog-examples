package bhuwanupadhyay.kubernetes;

import org.junit.Ignore;
import org.junit.Test;

import static bhuwanupadhyay.kubernetes.OrderStatus.PLACED;
import static org.junit.Assert.assertEquals;

public class OrderUnitTest {

    private static final String ORDER_ID = "1234";
    private static final String CUSTOMER_ID = "3213";
    private static final DeliveryAddress ADDRESS = new DeliveryAddress("Dubai");

    @Test
    @Ignore
    public void newOrder() {
        Order order = new Order(ORDER_ID, CUSTOMER_ID, ADDRESS);
        assertEquals(PLACED, order.getOrderStatus());
    }

}