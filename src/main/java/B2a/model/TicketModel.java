package B2a.model;

import B2a.domain.ticket.Ticket;
import B2a.domain.ticket.TicketOption;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketModel {
    Ticket ticket;
    List<TicketOption> option;
}
