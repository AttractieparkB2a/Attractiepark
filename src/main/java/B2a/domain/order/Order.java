package B2a.domain.order;

import B2a.domain.ticket.Ticket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long clientId;
    private Long ticketId;
    private Date date;
    private  int totalPrice;

    @OneToMany(cascade = javax.persistence.CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    public Order(Long id, Long clientId, Long ticketId, Date date, int totalPrice){
        this.id = id;
        this.clientId = clientId;
        this.ticketId = ticketId;
        this.date = date;
        this.totalPrice = totalPrice;
    }
}
