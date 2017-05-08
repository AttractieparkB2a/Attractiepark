package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class DefectState extends State {

    private Attraction attraction;

    public DefectState(Attraction attraction){
        this.attraction = attraction;
    }

    @Override
    public void repair() {
        System.out.println("Repairing the attraction. It can be opened in a minute");
        this.attraction.setState(new WaitingState(this.attraction));
    }
}
