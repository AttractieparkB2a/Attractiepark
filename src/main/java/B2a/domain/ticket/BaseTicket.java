package B2a.domain.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "base_ticket")
public abstract class BaseTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public abstract String name();
    public abstract int price();
}
