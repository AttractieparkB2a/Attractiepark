package B2a.domain;

import B2a.controller.interfaces.IMember;
import B2a.controller.interfaces.INewsMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Member extends IMember {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthday;

    private String address;
    private String city;
    private String zipcode;

    private String username;
    private String password;
    private String email;

    private boolean newsletter;

    public Member(String firstName, String lastName, Date birthday, String address, String city, String zipcode, String username, String password, String email, boolean newsletter, INewsMessage newsMessage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.username = username;
        this.password = password;
        this.email = email;
        this.newsletter = newsletter;

        if(newsletter) {
            newsMessage.attach(this);
        }
    }

    @Override
    public String update() {
        System.out.println(firstName + " received the email!");
        return email;
    }
}
