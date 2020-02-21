package io.github.bhuwanupadhyay.order;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

interface OrderRepository extends ReactiveCrudRepository<Order, String> {

    @Query("SELECT orderId, itemId, customerId FROM " + Order.TABLE + " WHERE customerId = :customerId")
    Flux<Order> findByCustomerId(@Param("customerId") String customerId);

}