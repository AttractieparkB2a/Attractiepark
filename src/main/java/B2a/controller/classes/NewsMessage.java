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

    @Override
    public void attach(IMember member) {
        members.add(member);
    }

    @Override
    public void notifyMembers() {
        for(IMember m : members) {
            m.update();
        }
    }

    public void sendNewsLetter() {
        final String username = "AttractieparkB2a@gmail.com";
        final String password = "B2aAttractiepar";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nielskerdel1996@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("nskerdel@hotmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
