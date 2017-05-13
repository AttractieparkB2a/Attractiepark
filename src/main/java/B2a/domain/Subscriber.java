package B2a.domain;

import B2a.domain.newsMessage.EmailService;
import B2a.domain.newsMessage.IUser;
import B2a.domain.newsMessage.NewsMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "subscriber")
public class Subscriber extends IUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @ManyToMany(mappedBy = "subscribers")
    List<NewsMessage> newsMessages;

    @Override
    public void update(String subject, String message) {
        EmailService emailService = EmailService.getInstance();
        emailService.sendNewsLetter(email, subject, message);
    }
}
