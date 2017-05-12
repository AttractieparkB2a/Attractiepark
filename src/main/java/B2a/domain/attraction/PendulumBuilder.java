package B2a.domain.attraction;

public class PendulumBuilder extends AttractionBuilder {

    private Attraction pendulumRide;

    @Override
    public Attraction createNewAttraction() {
        pendulumRide = new Attraction();
        build();
        return pendulumRide;
    }

    @Override
    public void setName() {
        pendulumRide.setName("penduluum");
    }

    @Override
    public void setDuration() {
        pendulumRide.setDuration( 2 );
    }

    @Override
    public void setMinimumHeight() {
        pendulumRide.setMinimumHeight( 60 );
    }

    @Override
    public void setTransportType() {
        pendulumRide.setTransportType("pendulum swing");
    }

    @Override
    public void setAmountStaff() {
        pendulumRide.setAmountStaff(2);
    }

    @Override
    public void setImage() {
        pendulumRide.customSetImage("pendulum");
    }
}
