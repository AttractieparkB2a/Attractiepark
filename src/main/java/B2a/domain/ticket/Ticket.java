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
    private int amount;
    public int price;

    public Ticket(String name, int amount, int price) {
        this.amount=amount;
        this.price = price;
        this.name = name;
    }

    public void add(Ticket p) {
        ticketItems.add(p);
    }

        @Override
        public String name() {
            return name;
        }

        @Override
        public int price() {
            this.price = 0;
            if(this.name == "Gold"){
                price = 25;
            }else if(this.name == "Silver"){
                price = 20;
            }else{
                price = 15;
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