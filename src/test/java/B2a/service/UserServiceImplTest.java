package B2a.service;

import B2a.domain.Role;
import B2a.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("production")
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void save() {
        User user = createUser("Test", "test", "TestFirstName", "Test", new Date(), "Test", "Test", "1111AA", false);

        User savedUser = findByUserName("Test");
        assertNotNull(savedUser);

        assertEquals(savedUser.getFirstName(), "TestFirstName");
    }

    @Test
    public void switchRole() {
        User user = createUser("Test2", "test", "TestFirstName2", "Test2", new Date(), "Test", "Test", "1111AA", false);
        Role role = new Role("ROLE_MEMBER");
        user.setRole(role);

        User savedUser = findByUserName("Test2");
        userService.switchRole(savedUser.getId());

        assertNotEquals(savedUser.getRole(), role);
    }

    private User createUser(String username, String password, String firstName, String lastName, Date birthday, String address, String city, String zipcode, boolean newsletter) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthday(birthday);
        user.setAddress(address);
        user.setCity(city);
        user.setZipcode(zipcode);
        user.setNewsletter(newsletter);

        userService.save(user);

        return user;
    }

    private User findByUserName(String username) {
        return userService.findByUsername(username);
    }
}
