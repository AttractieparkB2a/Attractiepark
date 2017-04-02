package B2a.domain.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class DecoratedTicket extends BaseTicket {

    @OneToOne
    protected BaseTicket ticket;

    protected DecoratedTicket(BaseTicket ticket) {

        this.ticket = ticket;
    }

}
