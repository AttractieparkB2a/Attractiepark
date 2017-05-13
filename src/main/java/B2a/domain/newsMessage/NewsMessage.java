package B2a.domain.newsMessage;

import B2a.domain.Subscriber;
import B2a.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "newsmessage")
public class NewsMessage implements INewsMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @Column(length = 2000)
    private String message;

    @ManyToMany
    @JoinTable(name = "newsmessage_user")
    List<User> user;

    @ManyToMany
    @JoinTable(name = "newsmessage_subscribers")
    List<Subscriber> subscribers;

    @Transient
    private List<IUser> users = new ArrayList<>();

    public NewsMessage(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    @Override
    public void attach(IUser user) {
        if(!users.contains(user))
            users.add(user);
    }

    @Override
    public boolean notifyUsers() {
        for(IUser iUser : users) {
            iUser.update(subject, message);
        }
        return users.size() > 0;
    }
}
