package B2a.model.order;

import B2a.model.OrderModel;

public class OrderMemento {
    private OrderModel order;

    public OrderMemento(OrderModel order){
        this.order = order;
    }

    public OrderModel getSavedState(){
        return order;
    }
}
