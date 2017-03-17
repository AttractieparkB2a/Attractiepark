package B2a.controller;

import B2a.domain.Account.Account;
import B2a.domain.Ticket.BaseTicket;
import B2a.domain.Ticket.Ticket;
import B2a.domain.Ticket.TicketOption;
import B2a.repository.BaseTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

public class TicketController {

    @Autowired
    private final BaseTicketRepository baseTicketRepository;


    public TicketController(BaseTicketRepository baseTicketRepository) {
        this.baseTicketRepository = baseTicketRepository;
    }

    private void createTicket() {
        Account acc = new Account();
        Ticket ticket = new Ticket();
        ticket = baseTicketRepository.save(ticket);
        ticket.add(acc);
    }

    private void decorateTicket() {
        BaseTicket concreteTicket  = baseTicketRepository.findOne(1L);
        BaseTicket decoratedTicket1 = new TicketOption("option1", 75, "basis", "19-1-19", concreteTicket);
        baseTicketRepository.save(decoratedTicket1);
        BaseTicket decoratedTicket2 = new TicketOption("option2", 50, "Hotel", "19-1-19", decoratedTicket1);
        baseTicketRepository.save(decoratedTicket2);
        BaseTicket decoratedTicket3 = new TicketOption("option3", 25, "Lunch", "19-1-19", decoratedTicket2);
        baseTicketRepository.save(decoratedTicket3);
        System.out.println("***** Your ticket has: " + decoratedTicket3);
        System.out.println("***** price: " + decoratedTicket3.price());
    }

    @Transactional
    @GetMapping
    public ModelAndView list() {
        createTicket();
        decorateTicket();
        Iterable<BaseTicket> tickets = baseTicketRepository.findAll();
        return new ModelAndView("ticketOrder", "ticket", tickets);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Ticket ticket) {
        createTicket();
        decorateTicket();
        return new ModelAndView("ticketOrder", "ticket", ticket);
    }

    @Transactional
    @GetMapping(params = "ticketOrderForm")
    public String ticketOrderForm(@ModelAttribute Ticket ticket) {
        createTicket();
        decorateTicket();
        return "ticketOrder";
    }
}
