package B2a.domain.attractionState;

import javax.persistence.Embeddable;

@Embeddable
public abstract class State {

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
