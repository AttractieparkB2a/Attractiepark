package B2a.service.concreteService;

import B2a.domain.attraction.*;
import B2a.repository.AttractionRepository;
import B2a.service.abstractService.AttractionManagerIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

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
            case "waterattraction":
                System.out.println("water");
                builder = new WaterBuilder();
                break;
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
        return attractionRepository.findAll();
    }

    // FIND ONE ATTRACTION BY IT'S ID
    public Attraction findAttraction(long id){
        return attractionRepository.findOne(id);
    }

    //GETS ALL ATTRACTIONTYPES SO BUTTONS IN THE CHOOSER CAN BE CREATED INSIDE A LOOP
    public Iterable<String> findAllAttractionTypes(){
        Iterable<Attraction> attractions = attractionRepository.findAll();
        ArrayList<String> returnIter = new ArrayList();
        for(Attraction a : attractions){
            boolean inList = false;

            // Write code to compare with list.

            if(inList == false){
                returnIter.add(a.getTransportType() );
            }

        }

        return null;
    }


    @Transactional
    public void changeState(Attraction attraction, String action){
        System.out.println("attraction in manager: " + attraction);
        System.out.println("action in manager: " + action);
        switch(action){
            case "open":
                attraction.open();
                //attractionRepository.save(attraction);
                System.out.println("status after in manager = " + attraction.getCurrentState());
                break;
            case "stop":
                attraction.stop();
                break;
            case "close":
                attraction.close();
                break;
            case "damage":
                attraction.damaged();
                break;
            case "repair":
                attraction.repair();
                break;
        }

        updateAttraction(attraction);


//        System.out.println("test attractie" + attraction.getCurrentState() );
//        Attraction tempA = attractionRepository.findOne( attraction.getId() );
//        tempA.setState( attraction.getCurrentState() );
//
//
//
//        //attractionRepository.delete( attraction.getId() );
//        attractionRepository.save(tempA);
    }


    @Transactional
    public void updateAttraction(Attraction toDeleteAttraction){

        System.out.println("test attractie" + toDeleteAttraction.getCurrentState() );
        Attraction tempA = new Attraction();
        tempA.setName( toDeleteAttraction.getName() );
        tempA.setDuration( toDeleteAttraction.getDuration() );
        tempA.setAmountStaff( toDeleteAttraction.getAmountStaff() );

        tempA.setState( toDeleteAttraction.getCurrentState() );

        //attractionRepository.delete( toDeleteAttraction.getId() );
        attractionRepository.save(tempA);

    }

}
