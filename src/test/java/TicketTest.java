import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TicketTest {
    @Test
    public void testifticketpaymentworks() {
        Ticket ticket = new Ticket(1);

        assertFalse((ticket.isPaid())); // checks if ticket is paid, assumes it's not
        ticket.pay(); // supposedly pays for ticket
        assertTrue((ticket.isPaid())); // checks if ticket is paid, assumes it is.
    }
}