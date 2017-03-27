package B2a.domain.attraction;

public abstract class AttractionBuilder {

    public abstract Attraction createNewAttraction(String name, int duration);

    //public abstract attraction buildAttraction(String type); // THIS IS THE FACTORY METHOD


    //public abstract attraction createAttraction();

}
