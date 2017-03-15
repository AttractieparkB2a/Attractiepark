package B2a.domain.Attraction;

/**
 * Created by ferdinand on 12-3-2017.
 */
public class LogFlume extends Attraction{

    @Override
    public void stop() {
        System.out.println("Stops moving the rubber floor which moves the boats.");
    }

}
