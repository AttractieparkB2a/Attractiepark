package B2a.domain.AttractionState;

import B2a.domain.Attraction.Attraction;

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
        System.out.println("Attraction was damaged");
        attraction.setState(new DefectState(attraction));
    }

}
