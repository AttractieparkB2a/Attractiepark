package B2a.controller;

import B2a.repository.ImageRepository;
import B2a.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("production")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ImageControllerTest {

    @Mock
    private ImageRepository imageRepository;

    @Mock
    private UserRepository userRepository;

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
    public void index() throws Exception {
        this.mockMvc.perform(
                get("/image/index/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>Foto | Overzicht")));
    }

    @Test
    public void createInvalid() throws Exception {
        mockMvc.perform(
                fileUpload("/image/create"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createValid() throws  Exception {
        MockMultipartFile file = new MockMultipartFile("test-file", "test.txt",
                null, "test data".getBytes());

        this.mockMvc.perform(
                fileUpload("/image/create")
                        .file(file)
                        .param("name", "Test Name"))
                .andExpect(redirectedUrl(null));
    }

    public void createUserImage() throws Exception {
        MockMultipartFile file = new MockMultipartFile("test-file", "test.txt",
                null, "test data".getBytes());

        this.mockMvc.perform(
                fileUpload("/image/create")
                        .file(file)
                        .param("name", "Test Name"))
                .andExpect(redirectedUrl(null));
    }
}
