package io.github.bhuwanupadhyay.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("WeakerAccess")
@RequiredArgsConstructor
@Component
class OrderHandler {

    private final OrderRepository repository;

    //    @Cacheable(value = "orderCache", key = "#orderId", unless = "#result == null")
    public Order getByOrderId(String orderId) {
        return repository.findById(orderId).orElse(null);
    }

    //    @Cacheable(value = "allOrdersCache", unless = "#result.size() == 0")
    public List<Order> getOrders() {
        return (List<Order>) repository.findAll();
    }

    //    @Caching(
//            put = @CachePut(value = "orderCache", key = "#order.orderId", unless = "#result == null"),
//            evict = @CacheEvict(value = "allOrdersCache", allEntries = true))
    public Order save(Order order) {
        return repository.save(order);
    }

    //    @Cacheable(value = "allOrdersByCustomerCache", key = "#customerId", unless = "#result.size() == 0")
    public List<Order> getByCustomerId(String customerId) {
        return repository.findAllByCustomerId(customerId);
    }

}
