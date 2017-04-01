package B2a.domain.newsMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

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
    private List<IUser> users = new ArrayList<>();

    public NewsMessage(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    @Override
    public void attach(IUser user) {
        users.add(user);
    }

    @Override
    public List<String> notifyUsers() {
        List<String> emails = new ArrayList<>();

        for (IUser m : users) {
            String email = m.update();
            if(!emails.contains(email))
                emails.add(email);
        }
        return emails;
    }
}
