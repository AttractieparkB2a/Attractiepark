package B2a.domain.Attraction;

import javax.persistence.Entity;

@Entity
public class Rollercoaster extends Attraction {


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
