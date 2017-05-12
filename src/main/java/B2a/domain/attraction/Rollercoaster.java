package B2a.domain.attraction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Rollercoaster extends Attraction {

    protected int maxSpeed;
    protected boolean hasLooping;

    @Override
    public void stop() {
        System.out.println("Using brakes to stop the rollercoaster");
    }
}
