package B2a.domain.attraction;

public abstract class AttractionBuilder {
    //Attraction attraction;

    public abstract Attraction createNewAttraction();

    public abstract void setName();
    public abstract void setDuration();
    public abstract void setMinimumHeight();
    public abstract void setTransportType();
    public abstract void setAmountStaff();
    public abstract void setImage();
    //public abstract void setState();
}
