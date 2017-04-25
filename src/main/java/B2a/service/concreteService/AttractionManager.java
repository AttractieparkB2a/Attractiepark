package B2a.service.concreteService;

import B2a.config.HibernateUtil;
import B2a.domain.attraction.*;
import B2a.domain.attractionState.State;
import B2a.repository.AttractionRepository;
import B2a.repository.StateRepository;
import B2a.service.abstractService.AttractionManagerIF;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;
//import com.journaldev.hibernate.util.HibernateUtil;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class AttractionManager implements AttractionManagerIF{
    private AttractionBuilder builder;
    @Autowired
    private final AttractionRepository attractionRepository;
    private final StateRepository stateRepository;

    public AttractionManager(AttractionRepository attractionRepository, StateRepository stateRepository){
        this.attractionRepository = attractionRepository;
        this.stateRepository = stateRepository;
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
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        switch(action){
            case "open":
                attraction.open();
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

        //System.out.println( attraction.getCurrentState() );
        //Attraction newAttraction = attraction;

        //attractionRepository.delete( attraction );

        session.saveOrUpdate( attraction );


        //attractionRepository.save( attraction );
//        List<State> allStates = (List<State>) stateRepository.findAll();
//        List<Attraction> allAttractions = (List<Attraction>) attractionRepository.findAll();
//
//        int counter = 0;
//        for(State s : allStates){
//            System.out.println("looping " + counter);
//            if(s.getAttraction().getId() == attraction.getId()){
//                counter++;
//                try{
//                    //System.out.println( "state id " + state.getId() );
//                    System.out.println( "attraction id from state " + s.getAttraction().getId() );
//                }
//                catch(Exception ex){
//
//                }
//            }
//        }
//        if(counter == 2)
//            stateRepository.delete( state );
//
//        long toRemove = attraction.getCurrentState().getId() -1;
//        System.out.println( "remove id = " + toRemove);
//
//        State removeState = stateRepository.findOne( toRemove );
//        removeState.setAttraction( null );
//
//        stateRepository.delete( removeState );

    }

    public void CustomDeleteForDoubles(long id, State state){
    }

}
