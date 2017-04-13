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
public class DefectState extends State{
    Attraction attraction;


    public DefectState(Attraction attraction){
        super(attraction);
    }

    @Override
    public void repair() {
        System.out.println("Repairing the attraction. It can be opened in a minute");
        //attraction.setState( attraction.getWaitingState());
        attraction.setState(new WaitingState(attraction));
    }
}
