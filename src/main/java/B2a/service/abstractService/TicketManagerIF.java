package B2a.service.abstractService;

import B2a.model.OrderModel;

public interface TicketManagerIF {
    void createTicket(OrderModel model);
    void decorateTicket(OrderModel model);
}
