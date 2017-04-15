package B2a.service.concreteService;

import B2a.domain.ticket.TicketProduct;
import B2a.repository.TicketProductRepository;
import B2a.service.abstractService.TicketProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketProductServiceImpl implements TicketProductService {

    private TicketProductRepository ticketProductRepository;

    @Autowired
    public TicketProductServiceImpl(TicketProductRepository ticketProductRepository) {
        this.ticketProductRepository = ticketProductRepository;
    }

    @Override
    public Iterable<TicketProduct> findAll() {
        return ticketProductRepository.findAll();
    }
}
