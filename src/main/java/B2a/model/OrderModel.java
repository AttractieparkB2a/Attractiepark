package B2a.model;

import B2a.domain.User;
import B2a.domain.ticket.Order;
import B2a.domain.ticket.Ticket;
import B2a.domain.ticket.TicketOption;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderModel {
    User account = new User();
    Order order = new Order();
    List<Ticket> ticket;
    List<TicketOption> option;
}
