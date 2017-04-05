//package B2a.service;
//
//import B2a.domain.newsMessage.newsMessage;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class NewsMessageServiceTest {
//
//    @Autowired
//    private NewsMessageService newsMessageService;
//
//    @Test
//    public void save() {
//        newsMessage newsMessage = createNewsMessage("Test Subject1", "Test Message1");
//
//        Iterable<newsMessage> newsMessages = newsMessageService.findAll();
//        assertNotNull(newsMessages);
//        boolean saved = false;
//        for(newsMessage n : newsMessages) {
//            if(newsMessage.getId().equals((n.getId())))
//                saved = true;
//        }
//        assertTrue(saved);
//    }
//
//    @Test
//    public void delete() {
//        newsMessage newsMessage = createNewsMessage("Test Subject2", "Test Message2");
//        Iterable<newsMessage> newsMessages = newsMessageService.findAll();
//        assertNotNull(newsMessages);
//        boolean saved = false;
//        for(newsMessage n : newsMessages) {
//            if(newsMessage.getId().equals((n.getId())))
//                saved = true;
//        }
//        assertTrue(saved);
//
//        newsMessageService.delete(newsMessage.getId());
//
//        Iterable<newsMessage> newsMessages2 = newsMessageService.findAll();
//        boolean deleted = true;
//        for(newsMessage n : newsMessages2) {
//            if(newsMessage.getId().equals((n.getId())))
//                deleted = false;
//        }
//        assertTrue(deleted);
//    }
//
//    @Test
//    public void update() {
//        newsMessage newsMessage = createNewsMessage("Test Subject3", "Test Message3");
//        newsMessage.setSubject("Test Subject4");
//        newsMessage.setMessage("Test Message4");
//
//        newsMessage newsMessage2 = newsMessageService.findOne(newsMessage.getId());
//        assertNotEquals("subject", "Test Subject4", newsMessage2.getSubject());
//        assertNotEquals("message", "Test Message4", newsMessage2.getMessage());
//    }
//
//    @Test
//    public void findNewsLetters() {
//        newsMessage newsMessage = new newsMessage("Test Subject5", "Test Subject5");
//        newsMessageService.findEmails(newsMessage);
//
//        Iterable<newsMessage> newsMessages = newsMessageService.findAll();
//        boolean notSaved = true;
//        for(newsMessage n : newsMessages) {
//            if(newsMessage.getSubject().equals((n.getSubject())))
//                notSaved = false;
//        }
//        assertTrue(notSaved);
//    }
//
//    private newsMessage createNewsMessage(String subject, String message) {
//        newsMessage newsMessage = new newsMessage();
//        newsMessage.setSubject(subject);
//        newsMessage.setMessage(message);
//
//        newsMessageService.save(newsMessage);
//        newsMessage retrieval = newsMessageService.findOne(newsMessage.getId());
//        assertNotNull(retrieval);
//        assertNotNull(retrieval.getId());
//        assertEquals("subject", subject, retrieval.getSubject());
//        assertEquals("message", message, retrieval.getMessage());
//
//        return retrieval;
//    }
//}
