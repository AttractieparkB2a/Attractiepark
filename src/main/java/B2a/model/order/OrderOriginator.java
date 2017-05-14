package B2a.model.order;

import B2a.model.OrderModel;

public class OrderOriginator {
    private OrderModel orderState;

    public void setState(OrderModel order){

        this.orderState = order;
    }

    public OrderModel getState(){
        return orderState;
    }

    public OrderMemento saveToMemento(){

        return new OrderMemento(orderState);
    }

    public OrderModel restoreFromMemento(OrderMemento m){

        return orderState = m.getSavedState();
    }

    public void clearMemento(){
        orderState = null;
    }
}
