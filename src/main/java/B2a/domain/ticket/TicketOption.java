package B2a.domain.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class
TicketOption extends DecoratedTicket {

    private String name;
    private String description;
    private int price;

    public TicketOption(String name, int price, String description, BaseTicket ticket) {
        super(ticket);
        this.description = description;
        this.name = name;
        this.price = price;
    }


    @Override
    public String name() {
        return ticket.name();
    }


    @Override
    public int price() {
        return price + ticket.price();
    }

    @Override
    public String toString() {
        return "option: " + name + "; " + ticket;
    }

}
