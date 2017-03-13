package B2a.domain.Attraction;

/**
 * Created by ferdinand on 13-3-2017.
 */
public abstract class PendulumRide extends Attraction{
    @Override
    public void start() {
        System.out.println("Starting to swing");
    }

    @Override
    public void stop(){
        System.out.println("Slows down the swing till it stops");
    }

    public abstract void rotate();
}
