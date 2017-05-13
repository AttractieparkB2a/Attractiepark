package B2a.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("production")
@SpringBootTest
public class NewsMessageControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void newsmessageIndex() throws Exception {
        this.mockMvc.perform(
                get("/newsmessage"))
                .andExpect(status().isOk());
    }

    @Test
    public void newsmessageInvalid() throws Exception {
        mockMvc.perform(
                post("/newsmessage"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("messageForm"))
                .andExpect(view().name("newsmessage"));
    }
}
