package B2a.service;

import B2a.domain.attraction.Attraction;
import B2a.domain.attraction.Rollercoaster;
import B2a.repository.AttractionRepository;
import B2a.repository.StateRepository;
import B2a.service.abstractService.AttractionManagerIF;
import B2a.service.concreteService.AttractionManager;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Assert;

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


    @Test
    public void changeState(){
        // Arrange
        Attraction testAttraction = new Rollercoaster();
        testAttraction.setId(999l);


        // Act

        // Assert

    }

}
