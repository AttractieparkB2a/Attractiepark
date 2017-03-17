package B2a.domain.Ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Decorated_Ticket")
public abstract class DecoratedTicket extends BaseTicket {

    @OneToOne
    protected BaseTicket ticket;

    protected DecoratedTicket(BaseTicket ticket) {

        this.ticket = ticket;
    }

}
