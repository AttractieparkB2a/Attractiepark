package B2a.service.abstractService;

import B2a.domain.User;
import B2a.domain.ticket.Order;
import B2a.model.OrderModel;

public interface OrderManagerIF {
    void addMemento(OrderModel model);
    OrderModel getMemento(int index);
    void createOrder(Order order);
    void clearMemento();
    Iterable<Order> findByClientId(User user);
}
