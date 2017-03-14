package B2a.domain.AttractionState;

import B2a.domain.Attraction.Attraction;

/**
 * Created by ferdinand on 13-3-2017.
 */
public class ClosedState extends State {
    Attraction attraction;

    public ClosedState(Attraction attraction){
        this.attraction = attraction;
    }

    @Override
    public void open() {
        System.out.println("Opening the attraction. Visitors can enter now.");
        attraction.setState(new WaitingState(attraction));
    }

}
