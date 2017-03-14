package B2a.domain.Attraction;

import B2a.domain.AttractionState.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by ferdinand on 12-3-2017.
 */

@Getter
@Setter
public abstract class Attraction {
    //ATTRIBUTES
    protected int duration ;
    protected int minimumAge;
    protected String transportType;

    private State closedState;
    private State runningState;
    private State waitingState;
    private State defectState;
    protected State currentState;


    public Attraction(){
        closedState = new ClosedState(this);
        runningState = new RunningState(this);
        waitingState = new WaitingState(this);
        defectState = new DefectState(this);

        currentState = new ClosedState(this);

    }

    //METHODS START HERE
    public void start(){
        currentState.start();
    };

    public void stop(){
        currentState.stop();
    };

    public void setState(State state){
        this.currentState = state;
    }

}
