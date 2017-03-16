package B2a.controller.classes;

import B2a.controller.interfaces.IMember;
import B2a.controller.interfaces.INewsMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class NewsMessage implements INewsMessage {

    private List<IMember> members = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    @Override
    public void attach(IMember member) {
        members.add(member);
    }

    @Override
    public void notifyMembers(String subject, String message) {
        for(IMember m : members) {
            String email = m.update();
            emails.add(email);
        }

        if(!emails.isEmpty()) {
            sendNewsLetter(emails, subject, message);
        }
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
