package io.github.bhuwanupadhyay.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
class OrderEndpoints {

    private final OrderHandler handler;

    @GetMapping
    public ResponseEntity<List<Order>> listOrders() {
        return ResponseEntity.ok(handler.getOrders());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(handler.save(order));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Order>> listOrdersByCustomerId(@PathVariable("customerId") String customerId) {
        return ResponseEntity.ok(handler.getByCustomerId(customerId));
    }

}