import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ParkingGarageTest {
    @Test
    public void testparkingspotinitialization() {
        ParkingGarage parkingGarage = new ParkingGarage(10); // create new Parkinggarage object with 10 spots
        assertEquals(10, parkingGarage.getAvailableSpots()); // Parkinggarage should initialize with 10 spots
    }
    @Test
    public void testavailablespots() {
        ParkingGarage parkingGarage = new ParkingGarage(5);
        assertTrue(parkingGarage.hasAvailableSpots()); // Garage should have spots

        parkingGarage.issueTicket();
        assertTrue(parkingGarage.hasAvailableSpots()); // Garage should still have available spots
    }
    @Test
    public void testissueticket() {
        ParkingGarage parkingGarage = new ParkingGarage(2);

        Ticket ticket1 = parkingGarage.issueTicket();
        assertNotNull(ticket1);
        assertEquals(1, ticket1.getTicketId()); // ticket should have ID 1
        assertEquals(1, parkingGarage.getAvailableSpots()); // Should be 1 spot left

        Ticket ticket2 = parkingGarage.issueTicket();
        assertNotNull(ticket2);
        assertEquals(2, ticket2.getTicketId()); // ticket should have ID 2
        assertEquals(0, parkingGarage.getAvailableSpots()); // Should be no spots left

        Ticket ticket3 = parkingGarage.issueTicket();
        assertNull(ticket3); // ticket should not get issued since no spots available
    }
    @Test
    public void testGarageExit() {
        ParkingGarage parkingGarage = new ParkingGarage(1);
                Ticket ticket = parkingGarage.issueTicket(); // issue ticket for test
        assertNotNull(ticket);

        parkingGarage.exitGarage(ticket);
        assertEquals(0, parkingGarage.getAvailableSpots()); // no spots available, car hasnt paid yet

        ticket.pay();
        parkingGarage.exitGarage(ticket);
        assertEquals(1, parkingGarage.getAvailableSpots()); // spot available because car paid and could leave
    }
    @Test
    public void testparkingfee() throws InterruptedException {
        ParkingGarage parkingGarage = new ParkingGarage(1);
        Ticket ticket = parkingGarage.issueTicket();

        TimeUnit.MINUTES.sleep(2);

        double fee = parkingGarage.calculateParkingFee(ticket);
        assertEquals(3.0, fee);
    }
}