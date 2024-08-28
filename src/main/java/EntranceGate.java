// This code belongs to Barnabas Szelenyi

//the entrance gate
public class EntranceGate {
    private ParkingGarage garage;

    // reference to the parkinggarage
    public EntranceGate(ParkingGarage garage) {
        this.garage = garage;
    }

    // Car entering the garage
    public Ticket enter() {
        if (garage.hasAvailableSpots()) { // available spots?
            Ticket ticket = garage.issueTicket(); // Issues a ticket.
            System.out.println("Car entered. Ticket issued. Ticket ID: " + ticket.getTicketId());
            return ticket;
        } else {
            System.out.println("No available spots. Car cannot enter.");
            return null;
        }
    }
}
