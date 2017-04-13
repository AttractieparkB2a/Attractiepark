package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Embeddable
@Entity
//@Getter
//@Setter
public class RunningState extends State {
    Attraction attraction;

    public RunningState(Attraction attraction){
        super(attraction);
        //this.attraction = attraction;
    }

    @Override
    public void stop() {
        System.out.println("Stopping the attraction");
        //attraction.setState(attraction.getWaitingState());
        attraction.setState(new WaitingState(attraction));
    }

    @Override
    public void damaged(){
        System.out.println("attraction was damaged");
        //attraction.setState(attraction.getDefectState());
        attraction.setState(new DefectState(attraction));
    }

}
