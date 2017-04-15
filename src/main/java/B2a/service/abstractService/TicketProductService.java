package B2a.service.abstractService;

import B2a.domain.ticket.TicketProduct;

public interface TicketProductService {
    Iterable<TicketProduct> findAll();
}
