package io.github.bhuwanupadhyay.tutorial;

import io.github.bhuwanupadhyay.tutorial.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}
