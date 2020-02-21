package io.github.bhuwanupadhyay.order;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.QueryHint;
import java.util.List;

interface OrderRepository extends CrudRepository<Order, String> {

    @QueryHints(value = {
            @QueryHint(name = "org.hibernate.cacheable", value = "true")
    })
    List<Order> findAll();

    @QueryHints(value = {
            @QueryHint(name = "org.hibernate.cacheable", value = "true")
    })
    List<Order> findAllByCustomerId(String customerId);

}
