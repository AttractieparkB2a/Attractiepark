package B2a.domain.Attraction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Rollercoaster extends Attraction {
    protected int maxSpeed;
    protected boolean hasLooping;

    public Rollercoaster(){
    }

    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void stop() {
        System.out.println("Using brakes to stop the rollercoaster");
    }
}
