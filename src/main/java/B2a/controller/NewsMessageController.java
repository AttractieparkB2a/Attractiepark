package B2a.controller;

import B2a.domain.Subscriber;
import B2a.domain.User;
import B2a.domain.newsMessage.NewsMessage;
import B2a.repository.SubscriberRepository;
import B2a.repository.UserRepository;
import B2a.service.NewsMessageServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class NewsMessageController {

    UserRepository userRepository;
    SubscriberRepository subscriberRepository;

    public NewsMessageController(UserRepository userRepository, SubscriberRepository subscriberRepository) {
        this.userRepository = userRepository;
        this.subscriberRepository = subscriberRepository;
    }

    @RequestMapping(value = "/newsmessage", method = RequestMethod.GET)
    public String newsmessage(Model model) {
       model.addAttribute("messageForm", new B2a.domain.newsMessage.NewsMessage());

       return "newsmessage";
    }

    @RequestMapping(value = "/newsmessage", method = RequestMethod.POST)
    public String newsmessage(@ModelAttribute("messageForm") NewsMessage messageForm, BindingResult bindingResult, Model model) {

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