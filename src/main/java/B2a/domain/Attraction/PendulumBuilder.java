package B2a.domain.Attraction;

public class PendulumBuilder extends AttractionBuilder {


    @Override
    public Attraction buildAttraction(String type) {
        if(type.equals("pirateship")){
            return new PirateShip();
        }
        else{
            return null;
        }


    }
}
