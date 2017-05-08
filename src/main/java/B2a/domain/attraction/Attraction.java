package B2a.domain.attraction;

import B2a.domain.attractionState.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.File;
import java.io.FileInputStream;

@Table(name = "attraction")
@Getter
@Setter
@Entity
public class Attraction {
    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    protected String name;

    protected int duration;
    protected int minimumHeight;
    protected String transportType;
    protected int amountStaff;
    @Column(columnDefinition="longblob")
    protected byte[] image;

    //@Embedded
    // mappedby = attraction
    @OneToOne(cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
    //@ManyToOne(targetEntity=State.class, cascade = javax.persistence.CascadeType.ALL)
    protected State currentState;

    //private long oldId;
    //@Embedded
    //@OneToOne
    //private State closedState;
    //@Embedded
    //@OneToOne
    //private State waitingState;
    //@Embedded
    //@OneToOne
    //private State defectState;
    //@Embedded
    //@OneToOne
    //private State runningState;


    public Attraction(){
        System.out.println("atractie constructor" + this);
//        closedState = new ClosedState(this);
//        //closedState.setName("closed");
//        waitingState = new WaitingState(this);
//        //waitingState.setName("waiting");
//        defectState = new DefectState(this);
//        runningState = new RunningState(this);
//        currentState = closedState;
        if(currentState == null){
            System.out.println("atractie currentstate is null");
            currentState = new ClosedState(this);
        }

    }

    //METHODS START HERE
    public String start(){
        System.out.println("teststart");
        return currentState.start();
    };

    public void open(){
        //System.out.println("open in attraction");
        System.out.println("status is: " + currentState);
        currentState.open();
        System.out.println("status is after: " + currentState);
    }

    public void stop(){
        currentState.stop();
    };

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
        File file = new File("src/main/resources/static/img/"+type+".png");
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        image = bFile;
    }

    public String generateBase64Image(){
        return Base64.encodeBase64String(this.getImage());
    }

    @Override
    public String toString(){
        return "Id " + id + "Naam: " + name + " Duur: " + duration + " minimum lengte: " + minimumHeight;
    }

}
