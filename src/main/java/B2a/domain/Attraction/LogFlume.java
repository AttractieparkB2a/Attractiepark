package B2a.domain.Attraction;

/**
 * Created by ferdinand on 12-3-2017.
 */
public class LogFlume extends Attraction{

    @Override
    public void start(){
        System.out.println("Starts moving the rubber floor to move the boats forward");
    }

    @Override
    public void stop() {
        System.out.println("Stops moving the rubber floor which moves the boats.");
    }

}
