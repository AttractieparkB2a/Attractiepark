package B2a.domain.ticket;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket extends BaseTicket {

    @OneToMany(cascade = javax.persistence.CascadeType.ALL)
    private List<Ticket> ticketItems = new ArrayList<>();
    private String name;
    private String date;

    public Ticket(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public void add(Ticket p) {
        ticketItems.add(p);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String date() {
        return date;
    }

    @Override
    public int price() {
        int price = 0;
           if(getName() == "gold"){
               price = 50;
           }
        return price;
    }

    @Override
    public String toString() {
        String s = "";
        for(Ticket item : ticketItems) {
            s += "product: " + item.getName() + "; ";
        }
        return s;
    }

}