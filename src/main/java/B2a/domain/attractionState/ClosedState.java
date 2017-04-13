package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Embeddable
@Entity
//@Getter
//@Setter
public class ClosedState extends State {
    @OneToOne
    Attraction attraction;

    public ClosedState(Attraction attraction){
        //this.attraction = attraction;
        super(attraction);
    }

    @Override
    public void open() {
        System.out.println("Opening the attraction. Visitors can enter now.");
        attraction.setState(attraction.getWaitingState());
        //attraction.setState(new ClosedState(attraction));
    }

    @Override
    public void damaged(){
        System.out.println("attraction was damaged");
        attraction.setState(attraction.getDefectState());
        //attraction.setState(new ClosedState(attraction));
    }

}
