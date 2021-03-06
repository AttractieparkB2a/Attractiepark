package B2a.domain;

import B2a.domain.image.UserImage;
import B2a.domain.newsMessage.EmailService;
import B2a.domain.newsMessage.IUser;
import B2a.domain.newsMessage.NewsMessage;
import B2a.domain.ticket.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "park_user")
public class User extends IUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Transient
    private String passwordConfirm;

    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String address;
    private String city;
    private String zipcode;

    private boolean newsletter;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    List<UserImage> userImages;

    @OneToMany(mappedBy = "clientId")
    List<Order> orders;

    @ManyToMany(mappedBy = "user")
    List<NewsMessage> newsMessages;

    public User(String username, String password, String passwordConfirm, String firstName, String lastName, Date birthday, String address, String city, String zipcode, boolean newsletter) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.newsletter = newsletter;
    }

    @Override
    public void update(String subject, String message) {
        EmailService emailService = EmailService.getInstance();
        emailService.sendNewsLetter(username, subject, message);
    }
}