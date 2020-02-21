package io.github.bhuwanupadhyay.order.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("WeakerAccess")
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public List<Order> getOrders() {
        return (List<Order>) repository.findAll();
    }
}
