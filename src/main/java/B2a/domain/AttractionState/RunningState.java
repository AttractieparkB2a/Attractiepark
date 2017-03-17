package B2a.domain.AttractionState;

import B2a.domain.Attraction.Attraction;

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


    @Override
    public void damaged(){
        System.out.println("Attraction was damaged");
        attraction.setState(new DefectState(attraction));
    }

}
