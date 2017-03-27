package B2a.service.concreteService;

import B2a.domain.attraction.*;
import B2a.repository.AttractionRepository;
import B2a.service.abstractService.AttractionManagerIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttractionManager implements AttractionManagerIF{
    private AttractionBuilder builder;
    @Autowired
    private final AttractionRepository attractionRepository;

    public AttractionManager(AttractionRepository attractionRepository){
        this.attractionRepository = attractionRepository;
    }

    @Override
    public Attraction createNewAttraction(String type) {
        switch(type){
            case "rollercoaster":
//                builder = new RollercoasterBuilder();
//                Rollercoaster rollercoaster = (Rollercoaster) builder.buildAttraction("rollercoaster");
//                rollercoaster.setName("Reversed Rollercoaster");
//                rollercoaster.setDuration( 4 );
//                return rollercoaster;

            case "pendulum":
//                builder = new PendulumBuilder();
//                PendulumRide pendulumRide = (PendulumRide) builder.buildAttraction("pirateShip");
//                pendulumRide.setName("Big Pirate Boat");
//                pendulumRide.setDuration( 3 );
//                pendulumRide.setTransportType("pirate boat");
//
//                return pendulumRide;
        }

        return null;
    }

    @Override
    public void saveAttraction(Attraction attraction) {
        attractionRepository.save(attraction);
    }

    @Override
    public Iterable<Attraction> findAllAttractions() {
        Attraction testData1 = new Rollercoaster();
        testData1.setName("testdata1");
        testData1.setDuration(2);
        testData1.setMinimumHeight(110);


        Rollercoaster testData2 = new Rollercoaster();
        testData2.setName("testdata2");
        testData2.setDuration(4);
        testData2.setMaxSpeed(100);


        attractionRepository.save( testData1 );
        attractionRepository.save( testData2 );

        return attractionRepository.findAll();
    }


}
