package B2a.controller;

import B2a.domain.newsMessage.NewsMessage;
import B2a.repository.NewsMessageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URL;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NewsMessageControllerTest {

    @Mock
    private NewsMessageRepository newsMessageRepository;

    @Autowired
    private WebApplicationContext context;

    @LocalServerPort
    private int port;


    private URL base;
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void newsmessageInvalid() throws Exception {
        mockMvc.perform(
                post("/newsmessage"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("messageForm"))
                .andExpect(view().name("newsmessage"));
    }

    @Test
    public void newsmessageValid() throws  Exception {
        when(newsMessageRepository.save(new NewsMessage()));

        mockMvc.perform(
                post("/newsmessage")
                        .param("subject", "Test Subject")
                        .param("message", "Test Message"))
                .andExpect(model().hasNoErrors())
                .andExpect(redirectedUrl("/"));
    }
}
