package B2a.service.abstractService;

import B2a.domain.ticket.Order;
import B2a.domain.ticket.Ticket;
import B2a.model.OrderModel;

import java.util.List;

public interface TicketManagerIF {
    void createTicket(OrderModel model);
    void decorateTicket(OrderModel model);
    List<Ticket> findByOrderId(Order order);
}
