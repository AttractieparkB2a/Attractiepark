package B2a.controller;

import B2a.service.abstractService.AttractionManagerIF;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("production")
@SpringBootTest
public class AttractionControllerTest {
    @Mock
    AttractionManagerIF attractionManagerIF;


    @Before
    public void setUp(){

    }


    @Test
    public void changeState(){

    }

}
