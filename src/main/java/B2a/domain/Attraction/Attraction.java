package B2a.domain.Attraction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ferdinand on 12-3-2017.
 */

@Getter
@Setter
public abstract class Attraction {
    protected int duration ;
    protected int minimumAge;
    protected String transportType;

    public abstract void start();

    public abstract void stop();

}
