package B2a.domain.attraction;

public abstract class PendulumRide extends Attraction{
    @Override
    public void stop(){
        System.out.println("Slows down the swing till it stops");
    }

    public abstract void rotate();
}
