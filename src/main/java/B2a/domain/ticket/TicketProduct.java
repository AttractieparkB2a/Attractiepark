package B2a.domain.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ticket_product")
public class TicketProduct {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private int price;

    public TicketProduct(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
