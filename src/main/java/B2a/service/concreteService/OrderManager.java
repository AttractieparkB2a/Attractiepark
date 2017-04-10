package B2a.service.concreteService;

import B2a.domain.order.Order;
import B2a.model.Order.OrderCaretaker;
import B2a.model.Order.OrderMemento;
import B2a.model.Order.OrderOriginator;
import B2a.model.OrderModel;
import B2a.repository.OrderRepository;
import B2a.service.abstractService.OrderManagerIF;

public class OrderManager implements OrderManagerIF {
    OrderCaretaker caretaker = new OrderCaretaker();
    OrderOriginator originator = new OrderOriginator();
    OrderRepository repo;
        public OrderManager(OrderRepository repo){
            this.repo = repo;
        }

        public Order createOrder(Order order){
           return repo.save(order);
        }

        public void saveState(OrderModel order){
            originator.set(order);
        }

        public void addMemento(){
            originator.saveToMemento();

        }

        public OrderMemento getMemento(int index){
            return caretaker.getMemento(index);
        }
}
