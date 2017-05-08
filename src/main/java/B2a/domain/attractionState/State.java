package B2a.domain.attractionState;

import B2a.domain.attraction.Attraction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Embeddable
@Entity
@Getter
@Setter
@Table(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    protected Attraction attraction;


    public State() {

    }

    public State(Attraction attraction){
        this.attraction = attraction;
    }


    public Attraction getStateAttraction(){
        return this.attraction;
    }

    public void open(){
        System.out.println("Invalid method");
    }

    public void close(){
        System.out.println("Invalid method");
    };

    public String start(){
        return "Invalid method";
    };

    public void stop(){
        System.out.println("Invalid method");
    };

    //java object has the standard method named wait. Therefore the name waiting was used.
    public void waiting(){
        System.out.println("Invalid method");
    }

    //public abstract void pause();

    public void repair(){
        System.out.println("Invalid method");
    };

    public void damaged(){
        System.out.println("The attration got damaged and is now defect.");
    }



}
