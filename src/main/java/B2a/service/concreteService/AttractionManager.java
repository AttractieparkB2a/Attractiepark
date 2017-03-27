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
                System.out.println("rollercoaster");
                builder = new RollercoasterBuilder();
                break;
            case "pendulum":
                System.out.println("pendulum");
                builder = new PendulumBuilder();
                break;
            case "water attraction":
                builder = new WaterBuilder();
            default:
                System.out.println("Default reached");
        }
        Attraction attraction = builder.createNewAttraction();
        attractionRepository.save(attraction);
        return attraction;
    }

    @Override
    public void saveAttraction(Attraction attraction) {
        attractionRepository.save(attraction);
    }

    @Override
    public Iterable<Attraction> findAllAttractions() {
        Attraction testData1 = new Rollercoaster();
        testData1.setId(10);
        testData1.setName("testdata1");
        testData1.setDuration(2);
        testData1.setMinimumHeight(110);


        Rollercoaster testData2 = new Rollercoaster();
        testData2.setId(20);
        testData2.setName("testdata2");
        testData2.setDuration(4);
        testData2.setMaxSpeed(100);


        attractionRepository.save( testData1 );
        attractionRepository.save( testData2 );

        return attractionRepository.findAll();
    }


}
