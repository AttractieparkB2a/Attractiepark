package B2a.service;

import B2a.domain.Subscriber;
import B2a.domain.User;
import B2a.domain.NewsMessage.NewsMessage;
import B2a.repository.NewsMessageRepository;
import B2a.repository.SubscriberRepository;
import B2a.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class NewsMessageServiceImpl implements NewsMessageService {

    private UserRepository userRepository;
    private SubscriberRepository subscriberRepository;
    private NewsMessageRepository newsMessageRepository;

    @Autowired
    private NewsMessageServiceImpl(UserRepository userRepository, SubscriberRepository subscriberRepository, NewsMessageRepository newsMessageRepository) {
        this.userRepository = userRepository;
        this.subscriberRepository = subscriberRepository;
        this.newsMessageRepository = newsMessageRepository;
    }

    @Override
    public void findEmails(NewsMessage messageForm) {

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
            sendNewsLetter(emails, subject, content);
            newsMessageRepository.save(newsMessage);
        }
    }

    @Override
    public void sendNewsLetter(List<String> email, String subject, String content) {
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
