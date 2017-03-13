package B2a.domain.Attraction;

/**
 * Created by ferdinand on 12-3-2017.
 */
public class RollercoasterBuilder extends AttractionBuilder {


    @Override
    public Attraction buildAttraction(String type) {
        if(type.equals("rollercoaster") ){
            return new Rollercoaster();
        }
        else if(type.equals("rollercoastertype2") ){
            return null;
        }
        else{
            return null;
        }

    }
}
