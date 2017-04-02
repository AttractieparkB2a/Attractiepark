package B2a.domain.AttractionState;

import B2a.domain.Attraction.Attraction;

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
    public String start() {
        attraction.setState( new RunningState(attraction));
        return "Starting the attraction";
    }


    @Override
    public void damaged(){
        System.out.println("attraction was damaged");
        attraction.setState(new DefectState(attraction));
    }

}
