package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;

public class DefectState extends State{
    Attraction attraction;


    public DefectState(Attraction attraction){
        this.attraction = attraction;
    }

    @Override
    public void repair() {
        System.out.println("Repairing the attraction. It can be opened in a minute");
        attraction.setState(new WaitingState(attraction));

    }
}
