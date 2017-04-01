package B2a.controller;

import B2a.domain.Subscriber;
import B2a.domain.User;
import B2a.domain.newsMessage.NewsMessage;
import B2a.repository.SubscriberRepository;
import B2a.repository.UserRepository;
import B2a.service.NewsMessageServiceImpl;
import B2a.validator.NewsMessageValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NewsMessageController {

    private UserRepository userRepository;
    private SubscriberRepository subscriberRepository;
    private NewsMessageValidator newsMessageValidator;

    public NewsMessageController(UserRepository userRepository, SubscriberRepository subscriberRepository, NewsMessageValidator newsMessageValidator) {
        this.userRepository = userRepository;
        this.subscriberRepository = subscriberRepository;
        this.newsMessageValidator = newsMessageValidator;
    }

    @RequestMapping(value = "/newsmessage", method = RequestMethod.GET)
    public String newsmessage(Model model) {
       model.addAttribute("messageForm", new NewsMessage());

       return "newsmessage";
    }

    @RequestMapping(value = "/newsmessage", method = RequestMethod.POST)
    public String newsmessage(@Valid @ModelAttribute("messageForm") NewsMessage messageForm, BindingResult bindingResult, Model model) {

        newsMessageValidator.validate(messageForm, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("messageForm", messageForm);
            return "newsmessage";
        }

        List<User> users = userRepository.findByNewsletter(true);
        Iterable<Subscriber> subscribers = subscriberRepository.findAll();


            String subject = messageForm.getSubject();
            String content = messageForm.getMessage();

            NewsMessage newsMessage = new NewsMessage(subject, content);

        for(User u : users) {
            newsMessage.attach(u);
        }

        for(Subscriber s : subscribers) {
            newsMessage.attach(s);
        }


        List<String> emails = newsMessage.notifyUsers();

        if(!emails.isEmpty()) {
            NewsMessageServiceImpl impl = new NewsMessageServiceImpl();
            impl.sendNewsLetter(emails, subject, content);
        }

        return "redirect:/";
    }
}