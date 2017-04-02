package B2a.domain.Order;

public class OrderMemento {
    private Order order;
    public OrderMemento(Order order){this.order = order;}
    public Order getSavedState(){return order;}
}
