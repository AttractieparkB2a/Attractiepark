package B2a.service.abstractService;

import B2a.domain.ticket.Ticket;
import B2a.model.OrderModel;

public interface TicketManagerIF {
    Ticket createTicket(OrderModel model);
    void decorateTicket(OrderModel model);
}
