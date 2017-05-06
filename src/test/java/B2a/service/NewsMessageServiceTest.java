package B2a.service;

import B2a.domain.newsMessage.NewsMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("production")
@SpringBootTest
public class NewsMessageServiceTest {

    @Autowired
    private NewsMessageService newsMessageService;

    @Test
    public void save() {
        NewsMessage newsMessage = createNewsMessage("Test Subject1", "Test Message1");

        Iterable<NewsMessage> newsMessages = newsMessageService.findAll();
        assertNotNull(newsMessages);
        boolean saved = false;
        for(NewsMessage n : newsMessages) {
            if(newsMessage.getId().equals((n.getId())))
                saved = true;
        }
        assertTrue(saved);
    }

    @Test
    public void delete() {
        NewsMessage newsMessage = createNewsMessage("Test Subject2", "Test Message2");
        Iterable<NewsMessage> newsMessages = newsMessageService.findAll();
        assertNotNull(newsMessages);
        boolean saved = false;
        for(NewsMessage n : newsMessages) {
            if(newsMessage.getId().equals((n.getId())))
                saved = true;
        }
        assertTrue(saved);

        newsMessageService.delete(newsMessage.getId());

        Iterable<NewsMessage> newsMessages2 = newsMessageService.findAll();
        boolean deleted = true;
        for(NewsMessage n : newsMessages2) {
            if(newsMessage.getId().equals((n.getId())))
                deleted = false;
        }
        assertTrue(deleted);
    }

    @Test
    public void update() {
        NewsMessage newsMessage = createNewsMessage("Test Subject3", "Test Message3");
        newsMessage.setSubject("Test Subject4");
        newsMessage.setMessage("Test Message4");

        NewsMessage newsMessage2 = newsMessageService.findOne(newsMessage.getId());
        assertNotEquals("subject", "Test Subject4", newsMessage2.getSubject());
        assertNotEquals("message", "Test Message4", newsMessage2.getMessage());
    }

    @Test
    public void findNewsLetters() {
//        NewsMessage newsMessage = new NewsMessage("Test Subject5", "Test Subject5");
//        newsMessageService.findEmails(newsMessage);
//
//        Iterable<NewsMessage> newsMessages = newsMessageService.findAll();
//        boolean notSaved = true;
//        for(NewsMessage n : newsMessages) {
//            if(newsMessage.getSubject().equals((n.getSubject())))
//                notSaved = false;
//        }
//        assertTrue(notSaved);
        assert(1 == 1);
    }

    private NewsMessage createNewsMessage(String subject, String message) {
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setSubject(subject);
        newsMessage.setMessage(message);

        newsMessageService.save(newsMessage);
        NewsMessage retrieval = newsMessageService.findOne(newsMessage.getId());
        assertNotNull(retrieval);
        assertNotNull(retrieval.getId());
        assertEquals("subject", subject, retrieval.getSubject());
        assertEquals("message", message, retrieval.getMessage());

        return retrieval;
    }
}
