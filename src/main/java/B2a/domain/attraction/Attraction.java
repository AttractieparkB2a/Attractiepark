package B2a.domain.attraction;

import B2a.domain.attractionState.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public abstract class Attraction {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    protected int id;
    protected String name;

    protected int duration ;
    protected int minimumHeight;
    protected String transportType;
    protected int amountStaff;
    protected byte[] image;

    @Embedded
    protected State currentState;


    public Attraction(){
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
