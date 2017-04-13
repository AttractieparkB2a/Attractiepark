package B2a.domain.attraction;

import B2a.domain.attractionState.ClosedState;

public class RollercoasterBuilder extends AttractionBuilder {
    Attraction rollercoaster;


    @Override
    public Attraction createNewAttraction() {
        rollercoaster = new Attraction();
        setName();
        setDuration();
        setMinimumHeight();
        setTransportType();
        setAmountStaff();
        setImage();
        return rollercoaster;

    }

    @Override
    public void setName() {
        rollercoaster.setName("rollercoasterrrrrr");
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

    public void setState(){
        ClosedState test = new ClosedState(rollercoaster);
        //test.setName("teststate");
        rollercoaster.setState(test);
    }


}
