package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Embeddable
@Entity
@NoArgsConstructor
//@Getter
//@Setter
public class ClosedState extends State {
    Attraction attraction;

//    public ClosedState(){
//        this.attraction = super.attraction;
//    }

    public ClosedState(Attraction attraction){
        this.attraction = attraction;
    }


    @Override
    public void open() {
        System.out.println("Opening the attraction. Visitors can enter now.");
        //attraction.setState(attraction.getWaitingState());
        //attraction.setState(new ClosedState(attraction));
        //this.attraction.setOldId( attraction.getCurrentState().getId() );
        State s = new WaitingState(this.attraction);

        // this.attraction.setState( new WaitingState(this.attraction) );
        this.attraction.setState( s );
        //attraction.setState( new WaitingState(attraction));

    }

    @Override
    public void damaged(){
        System.out.println("attraction was damaged");
        //attraction.setState(attraction.getDefectState());
        //attraction.setState(new ClosedState(attraction));
        //this.getStateAttraction().setState( new ClosedState(this.getStateAttraction() ) );

    }

}
