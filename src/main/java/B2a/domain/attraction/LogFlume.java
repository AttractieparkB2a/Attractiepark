package B2a.domain.attraction;

public class LogFlume extends Attraction{

    @Override
    public void stop() {
        System.out.println("Stops moving the rubber floor which moves the boats.");
    }

}
