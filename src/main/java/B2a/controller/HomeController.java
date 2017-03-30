package B2a.controller;

import B2a.domain.Subscriber;
import B2a.repository.SubscriberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    SubscriberRepository subscriberRepository;

    public HomeController(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("subscriberForm", new Subscriber());
        return "home";
    }



    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String index(@ModelAttribute("subscriberForm") Subscriber subscriber) {

        subscriberRepository.save(subscriber);

        return "home";
    }
}
