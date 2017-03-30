package B2a.domain;

import B2a.domain.newsMessage.INewsMessage;
import B2a.domain.newsMessage.IUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Subscriber extends IUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String emailaddress;

    public Subscriber(String emailaddress, INewsMessage newsMessage) {
        this.emailaddress = emailaddress;

        newsMessage.attach(this);
    }

    @Override
    public String update() {
        return emailaddress;
    }

}
