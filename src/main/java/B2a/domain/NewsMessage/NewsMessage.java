package B2a.domain.NewsMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class NewsMessage implements INewsMessage {

    @Id
    @GeneratedValue
    private Long id;

    private String subject;
    private String message;

    @Transient
    private List<IMember> members = new ArrayList<>();

    public NewsMessage(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    @Override
    public void attach(IMember member) {
        members.add(member);
    }

    @Override
    public List<String> notifyMembers() {
        List<String> emails = new ArrayList<>();

        for (IMember m : members) {
            String email = m.update();
            emails.add(email);
        }
        return emails;
    }
}
