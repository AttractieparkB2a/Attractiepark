package B2a.domain.Attraction;

import B2a.domain.AttractionState.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ferdinand on 12-3-2017.
 */

@Getter
@Setter
@Entity
@Table
public abstract class Attraction {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    protected int Id;
    protected String name;

    protected int duration ;
    protected int minimumAge;
    protected String transportType;


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
