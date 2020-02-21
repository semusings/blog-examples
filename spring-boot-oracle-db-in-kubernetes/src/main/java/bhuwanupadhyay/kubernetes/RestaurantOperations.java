package bhuwanupadhyay.kubernetes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class RestaurantOperations {

    private final OrderRepository repository;

    @PostMapping
    public ResponseEntity<OrderDto> placeOrder(OrderDto req) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(req);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(repository.findAll().stream().map(OrderDto::new).collect(toList()));
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    private static class OrderDto {
        private String orderId;
        private String address;

        public OrderDto(Order order) {
            this.orderId = order.getOrderId();
            this.address = order.getDeliveryAddress().getAddress();
        }
    }

}
