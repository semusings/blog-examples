package io.github.bhuwanupadhyay.order.domain;

import org.springframework.data.repository.CrudRepository;

interface OrderRepository extends CrudRepository<Order, String> {

}