package B2a.domain.Attraction;

public class LogFlumeBuilder extends AttractionBuilder {


    @Override
    public Attraction buildAttraction(String type) {
        return new LogFlume();
    }
}
