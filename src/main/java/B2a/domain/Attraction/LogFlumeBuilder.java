package B2a.domain.Attraction;

/**
 * Created by ferdinand on 12-3-2017.
 */
public class LogFlumeBuilder extends AttractionBuilder {


    @Override
    public Attraction buildAttraction(String type) {
        return new LogFlume();
    }
}
