package B2a.domain.Attraction;

public class PendulumBuilder extends AttractionBuilder {
    //PendulumRide pendulumRide;
    Attraction pendulumRide;


    @Override
    public Attraction createNewAttraction() {
        pendulumRide = new PendulumRide();
        pendulumRide.setName("penduluuuummm");
        pendulumRide.setDuration( 2 );
        pendulumRide.setMinimumHeight( 60 );
        pendulumRide.setTransportType("pendulum swing");
        //pendulumRide.setMaxRotationAngle(80);
        pendulumRide.customSetImage("pendulum");

        return pendulumRide;
    }
}
