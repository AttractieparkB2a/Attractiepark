//package B2a;
//
//import B2a.domain.newsMessage.NewsMessage;
//import B2a.repository.NewsMessageRepository;
//import B2a.service.NewsMessageService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.stream.StreamSupport;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class NewsMessageRepositoryTest {
//
//    private static final String NEWSMESSAGE_SUBJECT = "Test Subject";
//    private static final String NEWSMESSAGE_MESSAGE = "This is a test message";
//    private static final String NEWSMESSAGE_SUBJECT2 = "Test Subject2";
//    private static final String NEWSMESSAGE_MESSAGE2 = "This is a test message2";
//
//    @Autowired
//    private NewsMessageRepository newsMessageRepository;
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .build();
//
//        MockitoAnnotations.initMocks(this);
//    }
//
//
//    @Test
//    public void create() {
//
//        // execute
//        NewsMessage newsMessage = createNewsMessage(NEWSMESSAGE_SUBJECT, NEWSMESSAGE_MESSAGE);
//
//        // verify
//        Iterable<NewsMessage> newsMessages = newsMessageRepository.findAll();
//        assertNotNull(newsMessages);
//        assertTrue("Created newsmessage", StreamSupport.stream(newsMessages.spliterator(), false).anyMatch(newsMessage::equals));
//    }
//
//    @Test
//    public void delete() {
//        // prepare
//        NewsMessage newsMessage = createNewsMessage(NEWSMESSAGE_SUBJECT, NEWSMESSAGE_MESSAGE);
//        Iterable<NewsMessage> newsMessages = newsMessageRepository.findAll();
//        assertNotNull(newsMessages);
//        assertTrue("Created newsmessage", StreamSupport.stream(newsMessages.spliterator(), false).anyMatch(newsMessage::equals));
//
//        // execute
//        newsMessageRepository.delete(newsMessage.getId());
//
//        // verify
//        Iterable<NewsMessage> newsMessages2 = newsMessageRepository.findAll();
//        assertNotNull(newsMessages2);
//        assertTrue("Deleted newsmessage", StreamSupport.stream(newsMessages2.spliterator(), false).anyMatch(newsMessage::equals));
//    }
//
//    @Test
//    public void update() {
//        NewsMessage newsMessage = createNewsMessage(NEWSMESSAGE_SUBJECT, NEWSMESSAGE_MESSAGE);
//        newsMessage.setSubject(NEWSMESSAGE_SUBJECT2);
//        newsMessage.setMessage(NEWSMESSAGE_MESSAGE2);
//
//        NewsMessage newsMessage2 = newsMessageRepository.findOne(newsMessage.getId());
//        assertEquals("subject", NEWSMESSAGE_SUBJECT2, newsMessage2.getSubject());
//        assertEquals("message", NEWSMESSAGE_MESSAGE2, newsMessage2.getMessage());
//    }
//
//    private NewsMessage createNewsMessage(String subject, String message) {
//        NewsMessage newsMessage = new NewsMessage();
//        newsMessage.setSubject(subject);
//        newsMessage.setMessage(message);
//
//        newsMessageRepository.save(newsMessage);
//        NewsMessage retrieval = newsMessageRepository.findOne(newsMessage.getId());
//        assertNotNull(retrieval);
//        assertNotNull(retrieval.getId());
//        assertEquals("subject", subject, retrieval.getSubject());
//        assertEquals("message", message, retrieval.getMessage());
//
//        return retrieval;
//    }
//}
