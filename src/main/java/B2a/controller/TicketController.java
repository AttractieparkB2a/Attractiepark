package B2a.controller;

import B2a.domain.ticket.Ticket;
import B2a.domain.ticket.TicketOption;
import B2a.domain.User;
import B2a.model.OrderModel;
import B2a.model.TicketModel;
import B2a.repository.BaseTicketRepository;
import B2a.repository.RoleRepository;
import B2a.repository.UserRepository;
import B2a.service.UserService;
import B2a.service.UserServiceImpl;
import B2a.service.abstractService.TicketManagerIF;
import B2a.service.concreteService.TicketManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TicketController {

    private TicketManagerIF manager;
    private UserService userManager;
    private TicketModel ticketModel;

    public TicketController(BaseTicketRepository baseTicketRepository, UserRepository userRepo, RoleRepository roleRepo, BCryptPasswordEncoder encoder) {
        this.ticketModel = new TicketModel();
        this.manager = new TicketManager(baseTicketRepository);
        this.userManager = new UserServiceImpl(userRepo, roleRepo, encoder);
    }

    private void createTicket(TicketModel model) {
        manager.createTicket(model);
    }
    private void decorateTicket(TicketModel model) {
        manager.decorateTicket(model);
    }


    /////////////////PAS AAN DEZE PAGINA///////////////////////////////
    @RequestMapping(value = "orderTicket/ticketOrder", method = RequestMethod.GET)
    public ModelAndView ticketOrder() {
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User account  = userManager.findByUsername(authentication.getName());
        if(account != null){
            return new ModelAndView("orderTicket/ticketOrder", "account", account);
        }else{
            Date d = new Date();
            account = new User("Test", "Test", "Test",
                    "TestFirstname", "TestLastname", d, "TestAdres", "TestCity", "Test", true);
            return new ModelAndView("/orderTicket/ticketOrder", "account", account);
        }
    }


    /////////////////PAS AAN DEZE PAGINA///////////////////////////////
    @RequestMapping(value = "orderTicket/ticketOrder", method = RequestMethod.POST)
    public ModelAndView ticketOrder(User account) {
        OrderModel order = new OrderModel();
        order.setAccount(account);
        return new ModelAndView("/orderTicket/ticketOrderForm", "order", order);
    }

    @RequestMapping(value = "orderTicket/ticketOrderForm", method = RequestMethod.GET)
    public ModelAndView ticketOrderForm(OrderModel order) {

        //make new ticket and add to ticketModel
        Ticket ticketObject = new Ticket();
        TicketModel ticket = new TicketModel();
        ticket.setTicket(ticketObject);

        //put ticketmodel in arraylist and add to ordermodel
        ArrayList<TicketModel> ticketList = new ArrayList<>();
        order.setTickets(ticketList);

        //Arraylist of options of a a ticketand add them
        List<TicketOption> option = new ArrayList<TicketOption>();
        option.add(new TicketOption("Lunch", 5, "description", "22-58-86", ticketObject));
        option.add(new TicketOption("Cadeau", 75, "description", "22-58-86", ticketObject));
        ticket.setOption(option);

        return new ModelAndView("/orderTicket/ticketOrderForm", "order", order);
    }


    @RequestMapping(value = "orderTicket/ticketOrderForm", method = RequestMethod.POST)
    public ModelAndView ticketOrderForm(@ModelAttribute("ticketModel") TicketModel ticketModel, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/orderTicket/ticketOrderForm", "ticketModel", ticketModel);
       }

        System.out.println(ticketModel);

        //createTicket(ticketModel);
        //decorateTicket(ticketModel);
        return new ModelAndView("/orderTicket/ticketOrder", "ticketModel", ticketModel);
    }
}
