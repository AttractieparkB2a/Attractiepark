package B2a.repository;

import B2a.domain.order.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    @Override
    Iterable<Order> findAll();
}

