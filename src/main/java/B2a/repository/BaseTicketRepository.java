package B2a.repository;

import B2a.domain.ticket.BaseTicket;
import B2a.domain.ticket.Order;
import B2a.domain.ticket.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaseTicketRepository extends CrudRepository<BaseTicket, Long> {

    @Override
    Iterable<BaseTicket> findAll();

    List<Ticket> findAllByOrder(Order order);
}

