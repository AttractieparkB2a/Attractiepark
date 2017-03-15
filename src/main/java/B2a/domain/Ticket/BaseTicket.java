package B2a.domain.Ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseTicket {

    @Id
    @GeneratedValue
    private Long id;
    public abstract String name();
    public abstract String date();
    public abstract int price();
}
