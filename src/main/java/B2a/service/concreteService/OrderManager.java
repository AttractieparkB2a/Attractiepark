package B2a.service.concreteService;

import B2a.model.Order.OrderCaretaker;
import B2a.model.Order.OrderMemento;
import B2a.model.Order.OrderOriginator;
import B2a.model.OrderModel;
import B2a.service.abstractService.OrderManagerIF;

public class OrderManager implements OrderManagerIF {
    OrderCaretaker caretaker = new OrderCaretaker();
    OrderOriginator originator = new OrderOriginator();


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
