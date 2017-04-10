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
import B2a.service.abstractService.OrderManagerIF;
import B2a.service.abstractService.TicketManagerIF;
import B2a.service.concreteService.OrderManager;
import B2a.service.concreteService.TicketManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TicketController {

    private TicketManagerIF manager;
    private OrderManagerIF orderManager;
    private UserService userManager;
    private TicketModel ticketModel;
    private User account;
    private OrderModel order = new OrderModel();

    public TicketController(BaseTicketRepository baseTicketRepository, UserRepository userRepo, RoleRepository roleRepo, BCryptPasswordEncoder encoder) {
        this.ticketModel = new TicketModel();
        this.manager = new TicketManager(baseTicketRepository);
        this.orderManager = new OrderManager();
        this.userManager = new UserServiceImpl(userRepo, roleRepo, encoder);
    }

    private void createTicket(TicketModel model) {
        manager.createTicket(model);
    }

    private void decorateTicket(TicketModel model) {

        manager.decorateTicket(model);
    }

    private void saveOrderMemento(OrderModel order) {
        orderManager.saveState(order);
    }

    private void restoreDefaultOrder(int index) {
        orderManager.getMemento(0);
    }


    //=======================================================TICKETORDEr=========================================//
    @RequestMapping(value = "orderTicket/ticketOrder", method = RequestMethod.GET)
    public ModelAndView ticketOrder() {
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User account = userManager.findByUsername(authentication.getName());
        if (account != null) {
            return new ModelAndView("orderTicket/ticketOrder", "account", account);
        } else {
            Date d = new Date();
            account = new User("Test", "Test", "Test",
                    "TestFirstname", "TestLastname", d, "TestAdres", "TestCity", "Test", true);
            return new ModelAndView("orderTicket/ticketOrder", "account", account);
        }
    }

    @RequestMapping(value = "orderTicket/ticketOrder", method = RequestMethod.POST)
    public ModelAndView ticketOrder(User account) {
        this.account = account;
        return ticketOrderForm();
    }


    //=======================================================TICKETFORM=========================================//
    @RequestMapping(value = "orderTicket/ticketOrderForm", method = RequestMethod.GET)
    public ModelAndView ticketOrderForm() {

        order.setAccount(account);
        //make new ticket and add to ticketModel
        Ticket ticketObject = new Ticket("Gold", "11-05-2017");
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

        //saveStateToMemento
        System.out.println("Firstname: " + order.getAccount().getFirstName());
        System.out.println("ticket1: " + order.getTickets().size());
        saveOrderMemento(order);
        return new ModelAndView("orderTicket/ticketOrderForm", "order", order);
    }


    @RequestMapping(value = "orderTicket/ticketOrderForm", method = RequestMethod.POST)
    public String ticketOrderForm(@ModelAttribute("order") OrderModel order) {
        for (TicketModel ticket : order.getTickets()) {
            createTicket(ticket);
            decorateTicket(ticket);
        }
        return "orderTicket/ticketOrderResult";
    }

    //=======================================================TICKETRESULT=========================================//
    @RequestMapping(value = "orderTicket/ticketOrderResult", method = RequestMethod.GET)
    public ModelAndView ticketOrderResult() {

        return new ModelAndView("orderTicket/ticketOrderResult", "order", order);
    }


    @RequestMapping(value = "orderTicket/ticketOrderResult", method = RequestMethod.POST)
    public String ticketOrderResult(@RequestParam String action, @ModelAttribute("order") OrderModel order) {
        if (action.equals("buy")) {
            for (TicketModel ticket : order.getTickets()) {
                createTicket(ticket);
                decorateTicket(ticket);
            }
            return "orderTicket/ticketOrder";
        } else{
            return "orderTicket/ticketOrderResult";
        }
    }
}
