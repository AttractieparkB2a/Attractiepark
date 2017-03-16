package B2a.controller.classes;

import B2a.domain.Member;

import java.util.Date;

public class Main {
    public static void main(String args[]) {
        NewsMessage message = new NewsMessage();

        new Member("Niels", "Kerdel", new Date(26-2-1996), "Dr. blomsingel 31", "Krimpen aan den IJssel", "2922CD", "NielsKerdel", "1234", "nskerdel@hotmail.com", false, message);
        new Member("Bart", "Helleman", new Date(2-9-1996), "Schuwacht", "Lekkerkerk", "1234AA", "BartHelleman", "1234", "bart_helleman@hotmail.com", true, message);

        message.notifyMembers();
        message.sendNewsLetter();
    }
}
