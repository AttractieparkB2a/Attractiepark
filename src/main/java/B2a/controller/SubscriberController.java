package B2a.controller;

import B2a.domain.Subscriber;
import B2a.repository.SubscriberRepository;
import B2a.validator.SubscriberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@ControllerAdvice
@Controller
public class SubscriberController {

    private SubscriberRepository subscriberRepository;
    private SubscriberValidator subscriberValidator;

    @Autowired
    public SubscriberController(SubscriberRepository subscriberRepository, SubscriberValidator subscriberValidator) {
        this.subscriberRepository = subscriberRepository;
        this.subscriberValidator = subscriberValidator;
    }

    @ModelAttribute
    public void _layout(Model model) {
        model.addAttribute("subscriberForm", new Subscriber());
    }

    @RequestMapping(value = "/_layout", method = RequestMethod.POST)
    public String _layout(@Valid @ModelAttribute("subscriberForm") Subscriber subscriberForm, BindingResult bindingResult, Model model) {

        subscriberValidator.validate(subscriberForm, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("subscriberForm", subscriberForm);
            return "home";
        }

        subscriberRepository.save(subscriberForm);

        return "home";
    }
}
