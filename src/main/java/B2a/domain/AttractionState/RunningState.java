package B2a.domain.AttractionState;

import B2a.domain.Attraction.Attraction;

/**
 * Created by ferdinand on 13-3-2017.
 */
public class RunningState extends State {
    Attraction attraction;


    public RunningState(Attraction attraction){
        this.attraction = attraction;

    }

    @Override
    public void stop() {
        System.out.println("Stopping the attraction");
        attraction.setState(new WaitingState(attraction));

    }

}
