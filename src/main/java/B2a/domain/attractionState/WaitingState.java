package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Embeddable
//@Getter
//@Setter
@Entity
@NoArgsConstructor
public class WaitingState extends State {
    Attraction attraction;

    public WaitingState(Attraction attraction){
        //this.attraction = super.attraction;
        this.attraction = attraction;
    }

//    public WaitingState(){
//        this.attraction = super.attraction;
//    }

    @Override
    public void close() {
        System.out.println("Closing the attraction. No more visitors allowed in the line");
        //attraction.setState(attraction.getClosedState());
        //attraction.setState(new ClosedState());
        attraction.setState(new ClosedState(this.getStateAttraction() ));
    }

    @Override
    public String start() {
        //attraction.setState( attraction.getRunningState());
        attraction.setState(new RunningState(attraction));
        return "Starting the attraction";
    }


    @Override
    public void damaged(){
        System.out.println("attraction was damaged");
        //attraction.setState(attraction.getDefectState());
        //attraction.setState(new DefectState());
    }

}
