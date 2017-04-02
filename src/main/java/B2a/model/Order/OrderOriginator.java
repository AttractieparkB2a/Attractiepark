package B2a.domain.Order;

public class OrderOriginator {
    private Order order;

    public void set(Order order){
        this.order = order;
    }

    public OrderMemento saveToMemento(){
        return new OrderMemento(order);
    }

    public void restoreFromMemento(OrderMemento m){
        order = m.getSavedState();
    }
}
