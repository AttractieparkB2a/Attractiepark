package B2a.domain.attraction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class PendulumRide extends Attraction{
    int maxRotationAngle;

    public void rotate(){

    };
}
