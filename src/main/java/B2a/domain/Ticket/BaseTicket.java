package B2a.domain.Ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Base_Ticket")
public abstract class BaseTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public abstract String name();
    public abstract String date();
    public abstract int price();
}
