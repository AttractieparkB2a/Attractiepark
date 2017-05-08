package B2a.domain.attraction;

public class RollercoasterBuilder extends AttractionBuilder {

    private Attraction rollercoaster;

    @Override
    public Attraction createNewAttraction() {
        rollercoaster = new Attraction();
        build();
        return rollercoaster;
    }

    @Override
    public void setName() {
        rollercoaster.setName("rollercoaster");
    }

    @Override
    public void setDuration() {
        rollercoaster.setDuration(3);
    }

    @Override
    public void setMinimumHeight() {
        rollercoaster.setMinimumHeight(100);
    }

    @Override
    public void setTransportType() {
        rollercoaster.setTransportType("rollercoaster-carts");
    }

    @Override
    public void setAmountStaff() {
        rollercoaster.setAmountStaff(2);
    }

    @Override
    public void setImage() {
        rollercoaster.customSetImage("rollercoaster");
    }
}
