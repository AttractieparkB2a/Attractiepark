package B2a.domain.ticket;

import B2a.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ticket_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User clientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private int totalPrice;

    @OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "order")
    private List<Ticket> tickets = new ArrayList<>();

    public Order(Long id, User clientId, Date date, int totalPrice){
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.totalPrice = totalPrice;
    }
}
