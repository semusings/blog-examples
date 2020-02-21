package bhuwanupadhyay.kubernetes;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrderRepository extends JpaRepository<Order, String> {

}