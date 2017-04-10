package B2a.domain.attraction;

public class WaterBuilder extends AttractionBuilder {
    Attraction waterAttraction;

    @Override
    public Attraction createNewAttraction() {
        waterAttraction = new Attraction();
        setName();
        setDuration();
        setMinimumHeight();
        setTransportType();
        setAmountStaff();
        setImage();
        return waterAttraction;
    }

    @Override
    public void setName() {
        waterAttraction.setName("Waterrrride");
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
