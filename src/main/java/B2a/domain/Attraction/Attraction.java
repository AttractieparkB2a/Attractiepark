package B2a.domain.Attraction;

import B2a.domain.AttractionState.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;
import javax.persistence.*;
import java.io.File;
import java.io.FileInputStream;

@Getter
@Setter
@Entity
@Table
public abstract class Attraction {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    protected int id;
    protected String name;

    protected int duration ;
    protected int minimumHeight;
    protected String transportType;
    protected int amountStaff;
    @Column(columnDefinition="longblob")
    protected byte[] image;

    @Embedded
    protected State currentState;


    public Attraction(){
        currentState = new ClosedState(this);
    }

    //METHODS START HERE
    public String start(){
        return currentState.start();
    };

    public void stop(){
        currentState.stop();
    };

    public void close(){
        currentState.close();
    }

    public void  damaged(){
        currentState.damaged();
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


}
