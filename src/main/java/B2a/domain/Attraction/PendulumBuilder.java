package B2a.domain.Attraction;

/**
 * Created by ferdinand on 12-3-2017.
 */
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
