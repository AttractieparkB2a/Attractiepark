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
public class RunningState extends State {

    private Attraction attraction;

    public RunningState(Attraction attraction){
        this.attraction = attraction;
    }

    @Override
    public void stop() {
        System.out.println("Stopping the attraction");
        this.attraction.setState(new WaitingState(this.attraction));
    }

    @Override
    public void damaged(){
        System.out.println("Attraction was damaged");
        this.attraction.setState(new DefectState(this.attraction));
    }
}
