package B2a.domain;

import B2a.domain.newsMessage.INewsMessage;
import B2a.domain.newsMessage.IUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends IUser{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    @Transient
    private String passwordConfirm;

    private String firstName;
    private String lastName;
    private Date birthday;

    private String address;
    private String city;
    private String zipcode;

    private boolean newsletter;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String username, String password, String passwordConfirm, String firstName, String lastName, Date birthday, String address, String city, String zipcode, boolean newsletter, INewsMessage newsMessage) {
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

        if(newsletter) {
            newsMessage.attach(this);
        }
    }

    @Override
    public String update() {
        return username;
    }
}
