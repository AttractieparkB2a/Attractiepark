package B2a.controller;

import B2a.domain.NewsMessage.NewsMessage;
import B2a.domain.User;
import B2a.service.NewsMessageServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Controller
public class NewsMessageController {

    @RequestMapping(value = "/newsmessage", method = RequestMethod.GET)
    public String newsmessage(Model model) {
       model.addAttribute("messageForm", new NewsMessage());

       return "newsmessage";
    }

    @RequestMapping(value = "/newsmessage", method = RequestMethod.POST)
    public String newsmessage(@ModelAttribute("messageForm") NewsMessage messageForm, BindingResult bindingResult, Model model) {

            String subject = messageForm.getSubject();
            String content = messageForm.getMessage();

            NewsMessage message = new NewsMessage(subject, content);

            //new User("nskerdel@hotmail.com", "Kerdel","Kerdel", "Niels", "Kerdel", new Date(26-02-1996) , "Dr. blomsingel 31", "Krimpen aan den IJssel", "2922CD", true, message);

            List<String> emails = message.notifyUsers();

            if(!emails.isEmpty()) {
                NewsMessageServiceImpl impl = new NewsMessageServiceImpl();
                impl.sendNewsLetter(emails, subject, content);
            }

        return "redirect:/";
    }
}