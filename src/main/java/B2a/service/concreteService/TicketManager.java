package B2a.service.concreteService;

import B2a.domain.Ticket.BaseTicket;
import B2a.domain.Ticket.Ticket;
import B2a.domain.Ticket.TicketOption;
import B2a.model.TicketModel;
import B2a.repository.BaseTicketRepository;
import B2a.service.abstractService.TicketManagerIF;

import java.util.List;

public class TicketManager implements TicketManagerIF{

    private final BaseTicketRepository baseTicketRepository;

    public TicketManager(BaseTicketRepository baseTicketRepository) {
        this.baseTicketRepository = baseTicketRepository;
    }

    @Override
    public Ticket createTicket(TicketModel model) {
        Ticket ticket = model.getTicket();
        ticket = baseTicketRepository.save(ticket);
        ticket.add(ticket);
        return  ticket;
    }

    @Override
    public Ticket decorateTicket(TicketModel model) {
        List<TicketOption> option = model.getOption();
        for (TicketOption o : option){
            BaseTicket decoratedTicket1 = new TicketOption(o.name(), o.price(), o.getDescription(), o.getDate(), model.getTicket());
            baseTicketRepository.save(decoratedTicket1);
        }
        return model.getTicket();
    }

    @Override
    public void deleteTicket(Long ticketId) {
    baseTicketRepository.delete(ticketId);
    }
}
