package B2a.domain.attraction;

public class RollercoasterBuilder extends AttractionBuilder {
    //Rollercoaster rollercoaster;
    Attraction rollercoaster;


    @Override
    public Attraction createNewAttraction() {

        rollercoaster = new Rollercoaster();
        rollercoaster.setName("rollercoasterrrrrr");
        rollercoaster.setDuration( 3 );
        //rollercoaster.setMaxSpeed( 50 );
        rollercoaster.setMinimumHeight( 100 );
        rollercoaster.setTransportType("rollercoaster-carts");
        rollercoaster.customSetImage("rollercoaster");

        return rollercoaster;

    }
}
