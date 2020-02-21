package io.github.bhuwanupadhyay.sb.opizza.payment.query;

import org.springframework.data.repository.PagingAndSortingRepository;

interface JpaRepository extends PagingAndSortingRepository<PaymentEntity, String> {

}
