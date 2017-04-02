//package B2a;
//
//import B2a.domain.newsMessage.NewsMessage;
//import B2a.repository.NewsMessageRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.stream.StreamSupport;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class NewsMessageControllerTest {
//
//    private static final String NEWSMESSAGE_SUBJECT = "Test Subject";
//    private static final String NEWSMESSAGE_MESSAGE = "This is a test message";
//    private static final String NEWSMESSAGE_SUBJECT2 = "Test Subject2";
//    private static final String NEWSMESSAGE_MESSAGE2 = "This is a test message2";
//
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
//    @Test
//    public void newsmessage() throws Exception {
//        mockMvc.perform(post("/newsmessage")).andExpect(status().isOk())
//                .andExpect(model().attributeHasNoErrors("messageForm"))
//                .andExpect(view().name("/"));
//    }
//}
