//package B2a.service;
//
//import B2a.domain.User;
//import B2a.domain.image.image;
//import B2a.domain.image.UserImage;
//import B2a.domain.newsMessage.newsMessage;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.LinkedHashMap;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ImageServiceTest {
//
//    @Autowired
//    private ImageService imageService;
//
//    @Test
//    public void addImage() {
//        UserImage userImage = createUserImage("UserImage1");
//
//        Iterable<UserImage> userImages = imageService.findAll();
//        assertNotNull(userImages);
//        boolean saved = false;
//        for(UserImage u : userImages) {
//            if(userImage.getId().equals((u.getId())))
//                saved = true;
//        }
//        assertTrue(saved);
//    }
//
//    @Test
//    public void delete() {
//        UserImage userImage = createUserImage("UserImage2");
//        Iterable<UserImage> userImages = imageService.findAll();
//        assertNotNull(userImages);
//        boolean saved = false;
//        for(UserImage u : userImages) {
//            if(userImage.getId().equals((u.getId())))
//                saved = true;
//        }
//        assertTrue(saved);
//
//        imageService.delete(userImage.getId());
//
//        Iterable<UserImage> userImages2 = imageService.findAll();
//        boolean deleted = true;
//        for(UserImage u : userImages2) {
//            if(userImage.getId().equals((u.getId())))
//                deleted = false;
//        }
//        assertTrue(deleted);
//    }
//
//    @Test
//    public void update() {
//        UserImage userImage = createUserImage("UserImage3");
//        userImage.setName("UserImage4");
//
//        UserImage userImage2 = imageService.findOne(userImage.getId());
//        assertNotEquals("name", "UserImage4", userImage2.getName());
//    }
//
//
//    private UserImage createUserImage(String name) {
//        UserImage userImage = new UserImage();
//        userImage.setName(name);
//
//        imageService.addImage(null, userImage);
//        UserImage retrieval = imageService.findOne(userImage.getId());
//        assertNotNull(retrieval);
//        assertNotNull(retrieval.getId());
//        assertEquals("name", name, retrieval.getName());
//
//        return retrieval;
//    }
//}
