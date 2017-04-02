package B2a.domain.Ticket;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public int clientId;
    public int ticketId;
    public  String date;
    public  int totalPrice;
}
