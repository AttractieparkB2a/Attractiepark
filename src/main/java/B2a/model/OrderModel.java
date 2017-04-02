package B2a.model;

import B2a.domain.ticket.Order;
import B2a.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class OrderModel {
    User account = new User();
    Order order = new Order();
    ArrayList<TicketModel> tickets = new ArrayList<>();
}
