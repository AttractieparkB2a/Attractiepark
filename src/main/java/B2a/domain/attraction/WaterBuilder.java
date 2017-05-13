package B2a.domain.attraction;

public class WaterBuilder extends AttractionBuilder {

    private Attraction waterAttraction;

    @Override
    public Attraction createNewAttraction() {
        waterAttraction = new Attraction();
        build();
        return waterAttraction;
    }

    @Override
    public void setName() {
        waterAttraction.setName("Waterride");
    }

    @Override
    public void setDuration() {
        waterAttraction.setDuration( 4 );
    }

    @Override
    public void setMinimumHeight() {
        waterAttraction.setMinimumHeight( 100 );
    }

    @Override
    public void setTransportType() {
        waterAttraction.setTransportType("Log boats");
    }

    @Override
    public void setAmountStaff() {
        waterAttraction.setAmountStaff(3);
    }

    @Override
    public void setImage() {
        waterAttraction.customSetImage("waterattraction");
    }
}
