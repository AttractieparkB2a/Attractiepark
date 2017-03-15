package B2a.domain.Ticket;


import B2a.domain.Account.Account;
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
    private List<Account> ticketItems = new ArrayList<>();
    private String name;
    private String date;

    public void add(Account p) {
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
        for(Account item : ticketItems) {

            price += item.getAge();
        }
        return price;
    }

    @Override
    public String toString() {
        String s = "";
        for(Account item : ticketItems) {
            s += "product: " + item.getName() + "; ";
        }
        return s;
    }

}