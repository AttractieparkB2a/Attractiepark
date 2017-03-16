package B2a.domain.Attraction;

import B2a.domain.AttractionState.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ferdinand on 12-3-2017.
 */

@Getter
@Setter
@Entity
public abstract class Attraction {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    protected int Id;

    protected int duration ;
    protected int minimumAge;
    protected String transportType;

//    private State closedState;
//    private State runningState;
//    private State waitingState;
//    private State defectState;
    @Embedded
    protected State currentState;


    public Attraction(){
//        closedState = new ClosedState(this);
//        runningState = new RunningState(this);
//        waitingState = new WaitingState(this);
//        defectState = new DefectState(this);

        currentState = new ClosedState(this);

    }

    //METHODS START HERE
    public void start(){
        currentState.start();
    };

    public void stop(){
        currentState.stop();
    };

    public void close(){
        currentState.close();
    }

    public void  damaged(){
        currentState.damaged();
    }


    public void setState(State state){
        this.currentState = state;
    }

}
