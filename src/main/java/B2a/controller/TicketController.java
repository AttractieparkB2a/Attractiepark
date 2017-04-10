package B2a.controller;

import B2a.domain.User;
import B2a.domain.order.Order;
import B2a.domain.ticket.Ticket;
import B2a.domain.ticket.TicketOption;
import B2a.model.OrderModel;
import B2a.repository.BaseTicketRepository;
import B2a.repository.OrderRepository;
import B2a.repository.RoleRepository;
import B2a.repository.UserRepository;
import B2a.service.UserService;
import B2a.service.UserServiceImpl;
import B2a.service.abstractService.OrderManagerIF;
import B2a.service.abstractService.TicketManagerIF;
import B2a.service.concreteService.OrderManager;
import B2a.service.concreteService.TicketManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    private Model model;
    private TicketManagerIF manager;
    private OrderManagerIF orderManager;
    private UserService userManager;
    private Order orderObject;
    private OrderModel order = new OrderModel();

    public TicketController(OrderRepository Orepo, BaseTicketRepository baseTicketRepository, UserRepository userRepo,
                            RoleRepository roleRepo, BCryptPasswordEncoder encoder) {
        this.manager = new TicketManager(baseTicketRepository);
        this.orderManager = new OrderManager(Orepo);
        this.userManager = new UserServiceImpl(userRepo, roleRepo, encoder);
    }

    private void createTicket(OrderModel model) {
        manager.createTicket(model);
    }
    private void decorateTicket(OrderModel model) {manager.decorateTicket(model);}
    private void saveOrderMemento(OrderModel order) {orderManager.saveState(order);}
    private void restoreDefaultOrder(int index) {orderManager.getMemento(0);}
    private OrderModel setTickets(){
        //make new ticket and add to OrderModel
        Ticket ticketObject = new Ticket("Gold", 0,25);
        Ticket ticketObject2 = new Ticket("Silver", 0,20);
        Ticket ticketObject3 = new Ticket("Bronze", 0, 15);
        ArrayList<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticketObject);
        ticketList.add(ticketObject2);
        ticketList.add(ticketObject3);
        order.setTicket(ticketList);



        //Arraylist of options of a a ticketand add them
        List<TicketOption> option = new ArrayList<>();
        //GOLD OPTION
        option.add(new TicketOption("Lunch", 5, "description",  ticketObject));
        option.add(new TicketOption("Cadeau", 7, "description",  ticketObject));
        //ZILVER OPTION
        option.add(new TicketOption("Lunch", 5, "description",  ticketObject2));
        order.setOption(option);

        return order;
    }





    //=======================================================TICKETORDER=========================================//
    @RequestMapping(value = "orderTicket/ticketOrder", method = RequestMethod.GET)
    public ModelAndView ticketOrder() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
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
        order.setAccount(account);
        return ticketOrderForm();
    }

    //=======================================================TICKETFORM=========================================//
    @RequestMapping(value = "orderTicket/ticketOrderForm", method = RequestMethod.GET)
    public ModelAndView ticketOrderForm() {
        order = setTickets();
        //saveStateToMemento
        saveOrderMemento(order);
        return new ModelAndView("orderTicket/ticketOrderForm", "order", order);
    }


    @RequestMapping(value = "orderTicket/ticketOrderForm", method = RequestMethod.POST)
    public ModelAndView ticketOrderForm(@ModelAttribute("order") OrderModel order, BindingResult result, Model model) {
       this.order.setTicket(order.getTicket());
       saveOrderMemento(order);
        return ticketOrderResult();
    }





    //=======================================================TICKETRESULT=========================================//
    @RequestMapping(value = "orderTicket/ticketOrderResult", method = RequestMethod.GET)
    public ModelAndView ticketOrderResult() {
        for (Ticket t: order.getTicket()){
            for (TicketOption o: order.getOption()){
                    order.getOrder().setTotalPrice(t.price + o.price());
                }
            }
        return new ModelAndView("orderTicket/ticketOrderResult", "order", order);
    }

    @RequestMapping(value = "orderTicket/ticketOrderResult", method = RequestMethod.POST)
    public String ticketOrderResult(@RequestParam String action, @ModelAttribute("order") OrderModel order,  BindingResult result, Model model) {
        if (action.equals("koop")) {
            try{
            orderManager.createOrder(order.getOrder());
               createTicket(order);
               decorateTicket(order);
            }catch (Exception e){
                System.out.println(e);
            }

            restoreDefaultOrder(0);
            return "orderTicket/ticketOrder";
        } else{
            restoreDefaultOrder(0);
            return "orderTicket/ticketOrder";
        }
    }
}
