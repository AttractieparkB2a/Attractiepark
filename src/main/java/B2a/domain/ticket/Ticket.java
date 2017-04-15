package B2a.domain.ticket;


import B2a.domain.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Ticket extends BaseTicket {

    private String name;
    private int amount;
    public int price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Ticket(String name, int amount, int price) {
        this.amount=amount;
        this.price = price;
        this.name = name;
    }

    @Override
    public String name() {
            return name;
        }

    @Override
    public int price() {
        this.price = 10;

//        if(this.name == "Gold"){
//            price = 10;
//        }else if(this.name == "Silver"){
//            price = 10;
//        }else{
//            price = 10;
//        }
        return price;
    }
}