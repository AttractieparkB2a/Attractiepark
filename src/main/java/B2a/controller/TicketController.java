package B2a.controller;

import B2a.domain.Ticket.BaseTicket;
import B2a.domain.Ticket.Ticket;
import B2a.domain.Ticket.TicketOption;
import B2a.repository.BaseTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketController {

    @Autowired
    private final BaseTicketRepository baseTicketRepository;

    public TicketController(BaseTicketRepository baseTicketRepository) {
        this.baseTicketRepository = baseTicketRepository;
    }

    private void createTicket() {
        Ticket ticket = new Ticket("Gold", "11-05-2017");
        ticket = baseTicketRepository.save(ticket);
        ticket.add(ticket);
    }

    private void createNewTicket(Ticket ticket) {
        ticket = baseTicketRepository.save(ticket);
        ticket.add(ticket);
    }

    private void decorateTicket() {
        BaseTicket concreteTicket  = baseTicketRepository.findOne(1L);
        BaseTicket decoratedTicket1 = new TicketOption("option1", 75, "basis", "19-1-19", concreteTicket);
        baseTicketRepository.save(decoratedTicket1);
        BaseTicket decoratedTicket2 = new TicketOption("option2", 50, "Hotel", "19-1-19", decoratedTicket1);
        baseTicketRepository.save(decoratedTicket2);
        BaseTicket decoratedTicket3 = new TicketOption("option3", 25, "Lunch", "19-1-19", decoratedTicket2);
        baseTicketRepository.save(decoratedTicket3);
    }

    @RequestMapping(value = "/ticketOrder", method = RequestMethod.GET)
    public ModelAndView ticketOrder(Ticket ticket) {
        return new ModelAndView("ticketOrder", "Ticket", null);
    }

    @RequestMapping(value = "/ticketOrderForm", method = RequestMethod.GET)
    public ModelAndView ticketOrderForm(Ticket ticket) {

        return new ModelAndView("ticketOrderForm", "ticket", ticket);
    }

    @RequestMapping(value = "/ticketOrderForm", method = RequestMethod.POST)
    public ModelAndView ticketOrderForm(@ModelAttribute("ticketOrderForm") Ticket ticket, BindingResult bindingResult, Model model) {
        createNewTicket(ticket);
        decorateTicket();

//        if (bindingResult.hasErrors()) {
//            return new ModelAndView("ticketOrderForm", "ticket", ticket);
//        }
        return new ModelAndView("ticketOrder", "ticket", ticket);
    }
}
