package B2a.service.abstractService;

import B2a.domain.Ticket.Ticket;
import B2a.model.TicketModel;

public interface TicketManagerIF {
    Ticket createTicket(TicketModel model);
    Ticket decorateTicket(TicketModel model);
    void deleteTicket(Long ticketId);
}
