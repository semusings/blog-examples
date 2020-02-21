package io.github.bhuwanupadhyay.order;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface OrderRepository extends CrudRepository<Order, String> {

    List<Order> findAllByCustomerId(String customerId);

}
