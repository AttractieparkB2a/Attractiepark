package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    protected Attraction attraction;

    public State(Attraction attraction){
        this.attraction = attraction;
    }

    public void open(){
        System.out.println("Invalid method");
    }

    public void close(){
        System.out.println("Invalid method");
    }

    public void start(){
        System.out.println("Invalid method");
    }

    public void stop(){
        System.out.println("Invalid method");
    }

    public void waiting(){
        System.out.println("Invalid method");
    }

    public void repair(){
        System.out.println("Invalid method");
    }

    public void damaged(){
        System.out.println("Invalid method");
    }



}
