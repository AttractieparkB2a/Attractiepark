package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;

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

    @Override
    public void damaged(){
        System.out.println("attraction was damaged");
        attraction.setState(new DefectState(attraction));
    }

}
