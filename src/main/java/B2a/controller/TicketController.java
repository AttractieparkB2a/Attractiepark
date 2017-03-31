package B2a.controller;

import B2a.domain.Ticket.Ticket;
import B2a.domain.Ticket.TicketOption;
import B2a.model.TicketModel;
import B2a.repository.BaseTicketRepository;
import B2a.service.abstractService.TicketManagerIF;
import B2a.service.concreteService.TicketManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TicketController {

    @Autowired
    private final BaseTicketRepository baseTicketRepository;
    private TicketManagerIF manager;
    private TicketModel ticketModel;

    public TicketController(BaseTicketRepository baseTicketRepository) {
        this.ticketModel = new TicketModel();
        this.baseTicketRepository = baseTicketRepository;
        this.manager = new TicketManager(baseTicketRepository);
    }

    private void createTicket(TicketModel model) {
        manager.createTicket(model);
    }
    private void decorateTicket(TicketModel model) {
        manager.decorateTicket(model);
    }


    /////////////////PAS AAN DEZE PAGINA///////////////////////////////
    @RequestMapping(value = "/ticketOrder", method = RequestMethod.GET)
    public ModelAndView ticketOrder() {
        return new ModelAndView("ticketOrder", "Ticket", null);
    }


    /////////////////PAS AAN DEZE PAGINA///////////////////////////////
    @RequestMapping(value = "/ticketOrder", method = RequestMethod.POST)
    public ModelAndView ticketOrder(Ticket ticket) {

        return new ModelAndView("ticketOrderForm", "Ticket", ticket);
    }

    @RequestMapping(value = "/ticketOrderForm", method = RequestMethod.GET)
    public ModelAndView ticketOrderForm(Ticket ticket) {

        List<TicketOption> option = new ArrayList<TicketOption>();
        option.add(new TicketOption("Lunch", 5, "description", "22-58-86", ticket));
        option.add(new TicketOption("Cadeau", 75, "description", "22-58-86", ticket));

        ticketModel.setOption(option);
        ticketModel.setTicket(ticket);
        return new ModelAndView("ticketOrderForm", "ticketModel", ticketModel);
    }

    @RequestMapping(value = "/ticketOrderForm", method = RequestMethod.POST)
    public ModelAndView ticketOrderForm(@ModelAttribute("ticketModel") TicketModel ticketModel, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("ticketOrderForm", "ticketModel", ticketModel);
       }

        System.out.println(ticketModel.toString());

        //createTicket(ticketModel);
        //decorateTicket(ticketModel);
        return new ModelAndView("ticketOrder", "ticketModel", ticketModel);
    }
}
