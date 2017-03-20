package B2a.service.concreteService;

import B2a.domain.Attraction.*;
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
                builder = new RollercoasterBuilder();
                Rollercoaster rollercoaster = (Rollercoaster) builder.buildAttraction("rollercoaster");
                rollercoaster.setName("Reversed Rollercoaster");
                rollercoaster.setDuration( 4 );
                return rollercoaster;

            case "pendulum":
                builder = new PendulumBuilder();
                PendulumRide pendulumRide = (PendulumRide) builder.buildAttraction("pirateShip");
                pendulumRide.setName("Big Pirate Boat");
                pendulumRide.setDuration( 3 );
                pendulumRide.setTransportType("pirate boat");

                return pendulumRide;
        }

        return null;
    }
}
