package B2a.domain.Attraction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Rollercoaster extends Attraction {
    int maxSpeed;

    public Rollercoaster(String name){
        this.name = name;
        duration = 5;
        minimumAge = 12;
        transportType = "rollercoaster carts";
    }

    @Override
    public void stop() {
        System.out.println("Using brakes to stop the rollercoaster");
    }
}
