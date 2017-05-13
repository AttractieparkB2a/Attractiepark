package B2a.repository;

import B2a.domain.ticket.BaseTicket;
import B2a.domain.ticket.Order;
import B2a.domain.ticket.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface BaseTicketRepository extends CrudRepository<BaseTicket, Long> {

    @Override
    Iterable<BaseTicket> findAll();

    Iterable<Ticket> findAllByOrder(Order order);
}

