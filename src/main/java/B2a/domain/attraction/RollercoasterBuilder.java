package B2a.domain.attraction;

public class RollercoasterBuilder extends AttractionBuilder {
    Rollercoaster rollercoaster;


    @Override
    public Attraction createNewAttraction(String name, int duration) {

        rollercoaster = new Rollercoaster();
        rollercoaster.setName( name );
        rollercoaster.setDuration( duration );
        //rollercoaster.setMaxSpeed();
        //rollercoaster.setMinimumAge();
        rollercoaster.setTransportType("rollercoaster-carts");

        return rollercoaster;

    }
}
