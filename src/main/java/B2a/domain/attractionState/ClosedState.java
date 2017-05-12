package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class ClosedState extends State {

    private Attraction attraction;

    public ClosedState(Attraction attraction){
        this.attraction = attraction;
    }

    @Override
    public void open() {
        System.out.println("Opening attraction");
        this.attraction.setState(new WaitingState(this.attraction));
    }

    @Override
    public void damaged(){
        System.out.println("Attraction was damaged");
        this.attraction.setState(new DefectState(this.attraction));
    }
}
