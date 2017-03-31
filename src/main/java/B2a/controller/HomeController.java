package B2a.controller;

import B2a.domain.Subscriber;
import B2a.repository.SubscriberRepository;
import B2a.validator.SubscriberValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {

    private SubscriberRepository subscriberRepository;
    private SubscriberValidator subscriberValidator;

    public HomeController(SubscriberRepository subscriberRepository, SubscriberValidator subscriberValidator) {
        this.subscriberRepository = subscriberRepository;
        this.subscriberValidator = subscriberValidator;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("subscriberForm", new Subscriber());
        return "home";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String index(@Valid @ModelAttribute("subscriberForm") Subscriber subscriberForm, BindingResult bindingResult, Model model) {

        subscriberValidator.validate(subscriberForm, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("subscriberForm", subscriberForm);
            return "home";
        }

        subscriberRepository.save(subscriberForm);

        return "home";
    }
}
