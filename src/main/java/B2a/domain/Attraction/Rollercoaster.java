package B2a.domain.Attraction;

/**
 * Created by ferdinand on 12-3-2017.
 */
public class Rollercoaster extends Attraction {


    public Rollercoaster(){
        duration = 5;
        minimumAge = 12;
        transportType = "rollercoaster carts";
    }

    @Override
    public void start() {
        System.out.println("Starting the rollercoaster!");
    }

    @Override
    public void stop() {
        System.out.println("Using brakes to stop the rollercoaster");
    }
}
