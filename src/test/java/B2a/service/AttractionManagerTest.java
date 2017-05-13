package B2a.service;

import B2a.domain.attraction.Attraction;
import B2a.domain.attraction.Rollercoaster;
import B2a.domain.attractionState.*;
import B2a.repository.AttractionRepository;
import B2a.repository.StateRepository;
import B2a.service.abstractService.AttractionManagerIF;
import B2a.service.concreteService.AttractionManager;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("production")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AttractionManagerTest {
    AttractionManagerIF attractionManagerIF;
    AttractionRepository attractionRepository;
    StateRepository stateRepository;

    @Before
    public void setup(){
        attractionRepository = mock(AttractionRepository.class);
        stateRepository = mock(StateRepository.class);
        attractionManagerIF = new AttractionManager(attractionRepository, stateRepository);
    }

    // Creating a rollercoaster
    @Test
    public void createNewAttractionRollercoaster(){
        // Arrange
        String testType = "rollercoaster";
        // Act
        Attraction testAttraction = attractionManagerIF.createNewAttraction( testType );
        // Assert
        Assert.assertEquals("rollercoaster-carts", testAttraction.getTransportType());
    }

    // Creating a rollercoaster
    @Test
    public void createNewAttractionPendulum(){
        // Arrange
        String testType = "pendulum";
        // Act
        Attraction testAttraction = attractionManagerIF.createNewAttraction( testType );
        // Assert
        Assert.assertEquals("pendulum swing", testAttraction.getTransportType());
    }

    // Creating a rollercoaster
    @Test
    public void createNewAttractionWater(){
        // Arrange
        String testType = "waterattraction";
        // Act
        Attraction testAttraction = attractionManagerIF.createNewAttraction( testType );
        // Assert
        Assert.assertEquals("Log boats" ,testAttraction.getTransportType());
    }

    // Openening a rollercoaster
    @Test
    public void changeStateOpen(){
        // Arrange
        Attraction testAttraction = new Rollercoaster();
        testAttraction.setId(999L);

        State testState = new ClosedState(testAttraction);
        testState.setId(9999L);
        testAttraction.setState( testState );

        String testAction = "open";

        when(stateRepository.save(testState)).thenReturn( testState );

        // Act
        attractionManagerIF.changeState( testAttraction, testAction);

        // Assert
        Assert.assertEquals(WaitingState.class, testAttraction.getCurrentState().getClass());
    }

    @Test
    public void changeStateClose(){
        // Arrange
        Attraction testAttraction = new Rollercoaster();
        testAttraction.setId(999L);

        State testState = new WaitingState(testAttraction);
        testState.setId(9999L);
        testAttraction.setState( testState );

        String testAction = "close";

        when(stateRepository.save(testState)).thenReturn( testState );

        // Act
        attractionManagerIF.changeState( testAttraction, testAction);

        // Assert
        Assert.assertEquals(ClosedState.class, testAttraction.getCurrentState().getClass());
    }


    @Test
    public void changeStateDamage(){
        // Arrange
        Attraction testAttraction = new Rollercoaster();
        testAttraction.setId(999L);

        State testState = new WaitingState(testAttraction);
        testState.setId(9999L);
        testAttraction.setState( testState );

        String testAction = "damage";

        when(stateRepository.save(testState)).thenReturn( testState );

        // Act
        attractionManagerIF.changeState( testAttraction, testAction);

        // Assert
        Assert.assertEquals(DefectState.class, testAttraction.getCurrentState().getClass());
    }


    @Test
    public void changeStateStart(){
        // Arrange
        Attraction testAttraction = new Rollercoaster();
        testAttraction.setId(999L);

        State testState = new WaitingState(testAttraction);
        testState.setId(9999L);
        testAttraction.setState( testState );

        String testAction = "start";

        when(stateRepository.save(testState)).thenReturn( testState );

        // Act
        attractionManagerIF.changeState( testAttraction, testAction);

        // Assert
        Assert.assertEquals(RunningState.class, testAttraction.getCurrentState().getClass());
    }



    @Test
    public void changeStateStartInvalid(){
        // Arrange
        Attraction testAttraction = new Rollercoaster();
        testAttraction.setId(999L);

        State testState = new ClosedState(testAttraction);
        testState.setId(9999L);
        testAttraction.setState( testState );

        String testAction = "start";

        when(stateRepository.save(testState)).thenReturn( testState );

        // Act
        attractionManagerIF.changeState( testAttraction, testAction);

        // Assert
        Assert.assertEquals(ClosedState.class, testAttraction.getCurrentState().getClass());
    }


    @Test
    public void changeStateCloseInvalid(){
        // Arrange
        Attraction testAttraction = new Rollercoaster();
        testAttraction.setId(999L);

        State testState = new RunningState(testAttraction);
        testState.setId(9999L);
        testAttraction.setState( testState );

        String testAction = "close";

        when(stateRepository.save(testState)).thenReturn( testState );

        // Act
        attractionManagerIF.changeState( testAttraction, testAction);

        // Assert
        Assert.assertEquals(RunningState.class, testAttraction.getCurrentState().getClass());
    }

}
