package B2a.model;

import B2a.domain.User;
import B2a.domain.ticket.Order;
import B2a.domain.ticket.Ticket;
import B2a.domain.ticket.TicketOption;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
public class OrderModel {
    @Valid
    User account = new User();
    @Valid
    Order order = new Order();
    @Valid
    List<Ticket> ticket;
    @Valid
    List<TicketOption> option;
}
