package B2a.domain.AttractionState;

import B2a.domain.Attraction.Attraction;

/**
 * Created by ferdinand on 13-3-2017.
 */
public class WaitingState extends State {
    Attraction attraction;

    public WaitingState(Attraction attraction){
        this.attraction = attraction;

    }

    @Override
    public void close() {
        System.out.println("Closing the attraction. No more visitors allowed in the line");
        attraction.setState(new ClosedState(attraction));
    }

    @Override
    public void start() {
        System.out.println("Starting the attraction");
        attraction.setState( new RunningState(attraction));
    }

}
