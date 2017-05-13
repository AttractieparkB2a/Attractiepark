package B2a.domain.attraction;

public abstract class AttractionBuilder {
    public abstract Attraction createNewAttraction();

    public abstract void setName();
    public abstract void setDuration();
    public abstract void setMinimumHeight();
    public abstract void setTransportType();
    public abstract void setAmountStaff();
    public abstract void setImage();

    void build() {
        setName();
        setDuration();
        setMinimumHeight();
        setTransportType();
        setAmountStaff();
        setImage();
    }
}
