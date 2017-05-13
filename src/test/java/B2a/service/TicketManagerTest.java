package B2a.service;

import B2a.domain.ticket.BaseTicket;
import B2a.service.concreteService.TicketManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ActiveProfiles("production")
@SpringBootTest
public class TicketManagerTest {

    @Autowired
    TicketManager ticketManager;

    @Test
    public void sqlTicketsCreateTest() {
        Iterable<BaseTicket> iterableTickets = ticketManager.getAllTicket();
        assertNotNull(iterableTickets);
        }
    }