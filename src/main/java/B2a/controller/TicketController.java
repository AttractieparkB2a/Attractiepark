package B2a.controller;

import B2a.domain.User;
import B2a.domain.ticket.Order;
import B2a.domain.ticket.Ticket;
import B2a.domain.ticket.TicketOption;
import B2a.model.OrderModel;
import B2a.model.ticket.TicketModel;
import B2a.service.UserService;
import B2a.service.abstractService.TicketManagerIF;
import B2a.service.abstractService.TicketProductService;
import B2a.service.concreteService.OrderManager;
import B2a.validator.OrderUserValidator;
import B2a.validator.OrderValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TicketController {

    private OrderManager orderManager;
    private TicketManagerIF ticketManager;
    private UserService userService;
    private TicketProductService ticketProductService;
    private TicketModel ticketModel;
    private OrderModel order;
    private OrderUserValidator orderUserValidator;
    private OrderValidator orderValidator;

    public TicketController(OrderManager orderManager, TicketManagerIF ticketManager, UserService userService, TicketProductService ticketProductService, OrderValidator orderValidator) {
        this.orderManager = orderManager;
        this.ticketManager = ticketManager;
        this.userService = userService;
        this.ticketProductService = ticketProductService;
        this.ticketModel = new TicketModel();
        this.orderValidator = orderValidator;
    }




    //=======================================================TICKETORDER=========================================//
    @RequestMapping(value = "orderTicket/ticketOrder", method = RequestMethod.GET)
    public String ticketOrder(Model model) {
        order = new OrderModel();

        User account = userService.findUser();
        this.orderUserValidator = new OrderUserValidator(userService);

        if(account != null) {
            order.setAccount(account);
            order.getOrder().setClientId(account);
            model.addAttribute("account", account);
            return "orderTicket/ticketOrder";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "orderTicket/ticketOrder", method = RequestMethod.POST)
    public String ticketOrder(@ModelAttribute("account") User account, BindingResult result, Model model) {
        orderUserValidator.validate(account, result);

        if (result.hasErrors()) {
            model.addAttribute("account", account);
            return "orderTicket/ticketOrder";
        }

        orderManager.addMemento(order);
        return "redirect:/orderTicket/ticketOrderForm";
    }




    //=======================================================TICKETFORM=========================================//
    @RequestMapping(value = "orderTicket/ticketOrderForm", method = RequestMethod.GET)
    public String ticketOrderForm(Model model) {

        if(order.getTicket() == null){
        ArrayList<Ticket> tickets = new ArrayList<>();
        ticketModel.setTickets(tickets);
        ticketModel.setTicketProducts(ticketProductService.findAll());
        model.addAttribute("ticketModel", ticketModel);
        orderManager.addMemento(order);
        return "orderTicket/ticketOrderForm";
        }
        else
        {
        ArrayList<Ticket> tickets = new ArrayList<>();
        ticketModel.setTickets(tickets);
        ticketModel.setTicketProducts(ticketProductService.findAll());
        //add ticket from memento to ticketModel
        ticketModel.setTickets(order.getTicket());
        model.addAttribute("ticketModel", ticketModel);
        return "orderTicket/ticketOrderForm";
        }
    }


    @RequestMapping(value = "orderTicket/ticketOrderForm", method = RequestMethod.POST)
    public String ticketOrderForm(@ModelAttribute("ticketForm") TicketModel tickets, BindingResult result, Model model) {

        List<Ticket> ticketsList = new ArrayList<>();
        for(Ticket tm : tickets.getTickets()) {
            if(tm.getAmount() != 0) {
                tm.setPrice(tm.getPrice() * tm.getAmount());
                ticketsList.add(tm);
            }
        }

       order.setTicket(ticketsList);
       List<TicketOption> option = new ArrayList<>();

       for(Ticket t : tickets.getTickets()) {
           if (t.getName().equals("Gold")) {
               option.add(new TicketOption("Lunch", 5, "description", t.getAmount(), t));
               option.add(new TicketOption("Cadeau", 5, "description", t.getAmount(), t));
           } else if (t.getName().equals("Silver")) {
               option.add(new TicketOption("Lunch", 5, "description", t.getAmount(), t));
           }
       }
       order.setOption(option);
       orderManager.addMemento(order);
       return "redirect:/orderTicket/ticketOrderResult";
    }



    //=======================================================TICKETRESULT=========================================//
    @RequestMapping(value = "orderTicket/ticketOrderResult", method = RequestMethod.GET)
    public ModelAndView ticketOrderResult() {

        int totalPrice = 0;
        for (Ticket t: order.getTicket()){
            totalPrice += t.getPrice();
        }

        for(TicketOption o : order.getOption()) {
            totalPrice += o.getPrice() * o.getAmount();
        }

        order.getOrder().setTotalPrice(totalPrice);
        //order.getOrder().setDate(new Date());

        return new ModelAndView("orderTicket/ticketOrderResult", "order", order);
    }

    @RequestMapping(value = "orderTicket/ticketOrderResult", method = RequestMethod.POST)
    public String ticketOrderResult(@RequestParam String action, OrderModel eOrder, BindingResult result, Model model) {
        if (action.equals("buy")) {
            //Set Date from last page
            order.getOrder().setDate(eOrder.getOrder().getDate());

            orderValidator.validate(order, result);

            //if validator finds mistake go back to this page
            if (result.hasErrors()) {
                model.addAttribute("order", order);
                return "orderTicket/ticketOrderResult";
            }

            //create ticket and decorate and from there create memento
            orderManager.createOrder(order.getOrder());

            for(Ticket t : order.getTicket()) {
                t.setOrder(order.getOrder());
            }

            ticketManager.createTicket(order);
            ticketManager.decorateTicket(order);

            //make order empty and send back to homepage
            order = orderManager.getMemento(0);
            orderManager.clearMemento();
            return "redirect:/";

        }else if(action.equals("cancel")){
            //1 step back
            order = orderManager.getMemento(2);
            return "redirect:/orderTicket/ticketOrderForm";
        }else{
            //back to homepage there is something wrong
            order = orderManager.getMemento(0);
            orderManager.clearMemento();
            return "redirect:/";
        }

    }

    @RequestMapping(value = "ticketOverview", method = RequestMethod.GET)
    public String ticketOverview(Model model) {
        User user = userService.findUser();

        if(user != null) {
            Iterable<Order> orders = orderManager.findByClientId(user);
            model.addAttribute("orders", orders);

            List<Ticket> tickets = new ArrayList<>();

            for(Order o : orders) {
                List<Ticket> tempTicket = ticketManager.findByOrderId(o);
                tickets.addAll(tempTicket);
            }
            model.addAttribute("tickets", tickets);
        }

        return "ticketOverview";
    }
}
