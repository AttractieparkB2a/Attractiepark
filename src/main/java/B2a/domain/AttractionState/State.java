package B2a.domain.AttractionState;

/**
 * Created by ferdinand on 13-3-2017.
 */
public abstract class State {

    public abstract void goNext(State state);

    public abstract void start();

    public abstract void stop();

    public abstract void pause();

    public abstract void repair();



}
