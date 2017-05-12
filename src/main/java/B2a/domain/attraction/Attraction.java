package B2a.domain.attraction;

import B2a.domain.LoadFile;
import B2a.domain.attractionState.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;
import javax.persistence.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "attraction")
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int duration;
    private int minimumHeight;
    private String transportType;
    private int amountStaff;

    @Lob
    private byte[] image;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "attraction")
    private State currentState;

    public Attraction(){
        if(currentState == null){
            currentState = new ClosedState(this);
        }
    }

    public void start(){
        currentState.start();
    }

    public void open(){
        currentState.open();
    }

    public void stop(){
        currentState.stop();
    }

    public void close(){
        currentState.close();
    }

    public void  damaged(){
        currentState.damaged();
    }

    public void repair(){
        currentState.repair();
    }

    public void setState(State state){
        this.currentState = state;
    }

    public void customSetImage(String type){
        LoadFile loadFile = new LoadFile();
        image = loadFile.load(type);
    }

    public String generateBase64Image(){
        return Base64.encodeBase64String(this.getImage());
    }
}
