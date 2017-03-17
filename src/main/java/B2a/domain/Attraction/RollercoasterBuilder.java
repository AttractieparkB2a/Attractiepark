package B2a.domain.Attraction;

public class RollercoasterBuilder extends AttractionBuilder {


    @Override
    public Attraction buildAttraction(String type) {
        if(type.equals("rollercoaster") ){
            return new Rollercoaster("hardcoded");
        }
        else if(type.equals("rollercoastertype2") ){
            return null;
        }
        else{
            return null;
        }

    }
}
