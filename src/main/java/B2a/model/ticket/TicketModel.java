package B2a.model.ticket;

import B2a.domain.ticket.Ticket;
import B2a.domain.ticket.TicketProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketModel {
    private List<Ticket> tickets;
    private Iterable<TicketProduct> ticketProducts;
}
