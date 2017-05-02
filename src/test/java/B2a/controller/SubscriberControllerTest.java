package B2a.controller;

import B2a.domain.Subscriber;
import B2a.domain.image.UserImage;
import B2a.repository.ImageRepository;
import B2a.repository.SubscriberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("local")
@SpringBootTest
public class SubscriberControllerTest {

    @Mock
    private SubscriberRepository subscriberRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void _layoutValid() throws  Exception {
        when(subscriberRepository.save(new Subscriber()));

        mockMvc.perform(
                post("/_layout")
                .param("email", "test@email.com"))
                .andExpect(model().hasNoErrors())
                .andExpect(view().name("home"));
    }
}
