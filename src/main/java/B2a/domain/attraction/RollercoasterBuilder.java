package B2a.domain.Attraction;

public class RollercoasterBuilder extends AttractionBuilder {
    Rollercoaster rollercoaster;


    @Override
    public Attraction createNewAttraction() {

        rollercoaster = new Rollercoaster();
        rollercoaster.setName("rollercoaster name");
        rollercoaster.setDuration( 3 );
        rollercoaster.setMaxSpeed( 50 );
        rollercoaster.setMinimumHeight( 100 );
        rollercoaster.setTransportType("rollercoaster-carts");

        return rollercoaster;

    }
}
