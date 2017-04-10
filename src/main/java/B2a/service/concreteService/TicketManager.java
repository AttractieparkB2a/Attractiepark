package B2a.service.concreteService;

import B2a.domain.ticket.BaseTicket;
import B2a.domain.ticket.Ticket;
import B2a.domain.ticket.TicketOption;
import B2a.model.OrderModel;
import B2a.repository.BaseTicketRepository;
import B2a.service.abstractService.TicketManagerIF;

import java.util.List;

public class TicketManager implements TicketManagerIF{

    private final BaseTicketRepository baseTicketRepository;

    public TicketManager(BaseTicketRepository baseTicketRepository) {
        this.baseTicketRepository = baseTicketRepository;
    }

    @Override
    public Ticket createTicket(OrderModel model) {
        Ticket ticket = new Ticket();
        for (Ticket t: model.getTicket()){
            ticket = baseTicketRepository.save(t);
            ticket.add(t);
        }
        return  ticket;
    }

    @Override
    public void decorateTicket(OrderModel model) {
        List<TicketOption> option = model.getOption();
        List<Ticket> ticket = model.getTicket();

        for (TicketOption o : option) {
            for (Ticket t : ticket) {
                BaseTicket decoratedTicket = new TicketOption(o.name(), o.price(), o.getDescription(), t);
                baseTicketRepository.save(decoratedTicket);
                 }
        }
    }
}
