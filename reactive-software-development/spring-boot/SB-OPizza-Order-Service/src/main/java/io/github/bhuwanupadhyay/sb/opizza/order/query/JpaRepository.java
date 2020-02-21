package io.github.bhuwanupadhyay.sb.opizza.order.query;

import org.springframework.data.repository.PagingAndSortingRepository;

interface JpaRepository extends PagingAndSortingRepository<OrderData, String> {

}
