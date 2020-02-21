package io.github.bhuwanupadhyay.sb.opizza.order.domain;

import io.github.bhuwanupadhyay.sb.opizza.shared.OPizzaAssertError;
import org.junit.jupiter.api.Test;

import static io.github.bhuwanupadhyay.sb.opizza.order.domain.OrderId.MISSING_ORDER_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderIdUnitTests {

    @Test
    void allowedOnlyNonBlankString() {
        String id = "1232";

        assertEquals(id, new OrderId(id).value());
    }

    @Test
    void notAllowedBlankString() {
        OPizzaAssertError error = assertThrows(OPizzaAssertError.class, () -> new OrderId(" "));

        assertEquals(MISSING_ORDER_ID, error.getMessage());
    }

    @Test
    void notAllowedNull() {
        OPizzaAssertError error = assertThrows(OPizzaAssertError.class, () -> new OrderId(null));

        assertEquals(MISSING_ORDER_ID, error.getMessage());
    }

}