package B2a.controller;

import B2a.domain.NewsMessage.NewsMessage;
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

            String subject = "Winter sales";

            String content = "<b>Greetings,</b><br><br>";
            content += "Winter sales are coming and you can be the first the profit from it.<br>";
            content += "Head quick to our website to see what we can offer you!<br><br>";
            content += "-The AttractieparkB2a team";

            NewsMessage message = new NewsMessage(subject, content);

            List<String> emails = message.notifyUsers();

            if(!emails.isEmpty()) {
                sendNewsLetter(emails, subject, content);
            }

        return "redirect:/";
    }

    private void sendNewsLetter(List<String> email, String subject, String content) {
        final String username = "AttractieparkB2a@gmail.com";
        final String password = "B2aAttractiepar";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "*");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("AttractieparkB2a@gmail.com"));
            for (String anEmail : email) {
                message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(anEmail));
            }

            message.setSubject(subject);
            message.setContent(content, "text/html");

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}