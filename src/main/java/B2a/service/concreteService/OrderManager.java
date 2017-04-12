package B2a.service.concreteService;

import B2a.domain.order.Order;
import B2a.model.Order.OrderCaretaker;
import B2a.model.Order.OrderMemento;
import B2a.model.Order.OrderOriginator;
import B2a.model.OrderModel;
import B2a.repository.OrderRepository;
import B2a.service.abstractService.OrderManagerIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManager implements OrderManagerIF {

    private OrderRepository orderRepository;
    private OrderCaretaker caretaker;
    private OrderOriginator originator;

    @Autowired
    public OrderManager(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
        this.caretaker = new OrderCaretaker();
        this.originator = new OrderOriginator();
    }

    @Override
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    @Override
    public void saveState(OrderModel order){
        originator.set(order);
    }

    @Override
    public void addMemento(){
        originator.saveToMemento();
    }

    @Override
    public OrderMemento getMemento(int index){
        return caretaker.getMemento(index);
    }
}
