package B2a.service.abstractService;

import B2a.domain.order.Order;
import B2a.model.Order.OrderMemento;
import B2a.model.OrderModel;

public interface OrderManagerIF {
    void saveState(OrderModel order);
    void addMemento();
    OrderMemento getMemento(int index);
    Order createOrder(Order order);
}
