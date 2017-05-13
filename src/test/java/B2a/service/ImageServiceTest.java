package B2a.service;

import B2a.domain.User;
import B2a.domain.image.UserImage;
import B2a.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("production")
@SpringBootTest
public class ImageServiceTest {

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addImage() {
        UserImage userImage = createUserImage("UserImage1", null);

        Iterable<UserImage> userImages = imageService.findAll();
        assertNotNull(userImages);
        boolean saved = false;
        for(UserImage u : userImages) {
            if(userImage.getId().equals((u.getId())))
                saved = true;
        }
        assertTrue(saved);
    }

    @Test
    public void delete() {
        UserImage userImage = createUserImage("UserImage2", null);
        Iterable<UserImage> userImages = imageService.findAll();
        assertNotNull(userImages);
        boolean saved = false;
        for(UserImage u : userImages) {
            if(userImage.getId().equals((u.getId())))
                saved = true;
        }
        assertTrue(saved);

        imageService.delete(userImage.getId());

        Iterable<UserImage> userImages2 = imageService.findAll();
        boolean deleted = true;
        for(UserImage u : userImages2) {
            if(userImage.getId().equals((u.getId())))
                deleted = false;
        }
        assertTrue(deleted);
    }

    @Test
    public void update() {
        UserImage userImage = createUserImage("UserImage3", null);
        userImage.setName("UserImage4");

        UserImage userImage2 = imageService.findOne(userImage.getId());
        assertNotEquals("name", "UserImage4", userImage2.getName());
    }

    @Test
    public void findByUserId() {
        User user = createUser("test1@test.nl", "Test1234");
        UserImage userImage = createUserImage("UserImage5", user);

        List<UserImage> userImages = imageService.findByUserId(userImage.getUser().getId());
        assertNotNull(userImages);

        boolean saved = false;
        for(UserImage u : userImages) {
            if(userImage.getId().equals((u.getId())))
                saved = true;
        }
        assertTrue(saved);
    }

    @Test
    public void findUserIdById() {
        User user = createUser("test2@test.nl", "Test1234");
        UserImage userImage = createUserImage("UserImage6", user);

        Long id = imageService.findUserIdById(userImage.getId());
        assertEquals("id", userImage.getUser().getId(), id);
    }

    private UserImage createUserImage(String name, User user) {
        UserImage userImage = new UserImage();
        userImage.setName(name);
        if(user != null)
            userImage.setUser(user);

        imageService.addImage(null, userImage);
        UserImage retrieval = imageService.findOne(userImage.getId());
        assertNotNull(retrieval);
        assertNotNull(retrieval.getId());
        assertEquals("name", name, retrieval.getName());

        return retrieval;
    }

    private User createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);
        User retrieval = userRepository.findOne(user.getId());
        assertNotNull(retrieval);
        assertNotNull(retrieval.getId());
        assertEquals("username", username, retrieval.getUsername());

        return retrieval;
    }
}
