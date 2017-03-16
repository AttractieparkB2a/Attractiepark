package B2a.controller.classes;

import B2a.domain.Member;
import java.util.Date;

public class Main {
    public static void main(String args[]) {
        NewsMessage message = new NewsMessage();

        new Member("Niels", "Kerdel", new Date(26-2-1996), "Dr. blomsingel 31", "Krimpen aan den IJssel", "2922CD", "NielsKerdel", "1234", "nskerdel@hotmail.com", true, message);
        new Member("Bart", "Helleman", new Date(2-9-1996), "Schuwacht", "Lekkerkerk", "1234AA", "BartHelleman", "1234", "nielskerdel1996@gmail.com", false, message);

        String content = "<b>Greetings,</b><br><br>";
        content += "Winter sales are coming and you can be the first the profit from it.<br>";
        content += "Head quick to our website to see what we can offer you!<br><br>";
        content += "-The AttractieparkB2a team";

        String subject = "Winter sales";

        message.notifyMembers(subject, content);
    }
}
