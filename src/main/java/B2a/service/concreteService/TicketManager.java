package B2a.service.concreteService;

import B2a.domain.ticket.BaseTicket;
import B2a.domain.ticket.Ticket;
import B2a.domain.ticket.TicketOption;
import B2a.model.OrderModel;
import B2a.repository.BaseTicketRepository;
import B2a.service.abstractService.TicketManagerIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketManager implements TicketManagerIF{

    private final BaseTicketRepository baseTicketRepository;

    @Autowired
    public TicketManager(BaseTicketRepository baseTicketRepository) {
        this.baseTicketRepository = baseTicketRepository;
    }

    public Iterable<BaseTicket> getAllTicket(){
        return  this.baseTicketRepository.findAll();
    }

    @Override
    public void createTicket(OrderModel model) {
        for (Ticket t: model.getTicket()){
            baseTicketRepository.save(t);
        }
    }

    @Override
    public void decorateTicket(OrderModel model) {
        for (TicketOption o : model.getOption()) {
            if (o.getAmount() > 0){
               baseTicketRepository.save(o);
            }
        }
    }
}
