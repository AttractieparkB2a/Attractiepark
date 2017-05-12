package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Embeddable
@Entity
@NoArgsConstructor
//@Getter
//@Setter
public class DefectState extends State{
    Attraction attraction;


//    public DefectState(){
//        this.attraction = super.attraction;
//    }

    public DefectState(Attraction attraction){
        this.attraction = attraction;
    }


    @Override
    public void repair() {
        System.out.println("Repairing the attraction. It can be opened in a minute");
        this.getStateAttraction().setState( new WaitingState( this.attraction ) );
    }
}
