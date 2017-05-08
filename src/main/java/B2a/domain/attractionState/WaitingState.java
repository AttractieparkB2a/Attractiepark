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
public class WaitingState extends State {

    private Attraction attraction;

    public WaitingState(Attraction attraction){
        this.attraction = attraction;
    }

    @Override
    public void close() {
        System.out.println("Closing the attraction. No more visitors allowed in the line");
        this.attraction.setState(new ClosedState(this.attraction));
    }

    @Override
    public void start() {
        System.out.println("The attraction is now running");
        this.attraction.setState(new RunningState(this.attraction));
    }

    @Override
    public void damaged(){
        System.out.println("Attraction was damaged");
        this.attraction.setState(new DefectState(this.attraction));
    }
}
