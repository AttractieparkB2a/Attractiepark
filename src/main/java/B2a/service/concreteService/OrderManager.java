package B2a.service.concreteService;

import B2a.domain.User;
import B2a.domain.ticket.Order;
import B2a.model.OrderModel;
import B2a.model.order.OrderCaretaker;
import B2a.model.order.OrderOriginator;
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
    public void createOrder(Order order){
             orderRepository.save(order);
    }



    @Override
    public void addMemento(OrderModel model){
        originator.setState(model);
        caretaker.addMemento(originator.saveToMemento());
    }

    @Override
    public OrderModel getMemento(int index){
        return originator.restoreFromMemento(caretaker.getMemento(index));
    }

    @Override
    public Order findByClientId(User user) {
        return orderRepository.findByClientId(user);
    }
}
