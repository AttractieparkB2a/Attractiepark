package B2a.model.Order;

import B2a.model.OrderModel;

public class OrderOriginator {
    private OrderModel order;

    public void set(OrderModel order){
        this.order = order;
    }

    public OrderMemento saveToMemento(){
        return new OrderMemento(order);
    }

    public void restoreFromMemento(OrderMemento m){
        order = m.getSavedState();
    }
}
