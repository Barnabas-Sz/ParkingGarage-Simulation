// This code belongs to Barnabas Szelenyi

import java.util.ArrayList;
import java.util.List;

// the parking garage
public class ParkingGarage {
    private int availableSpots;
    private List<Ticket> tickets;
    private double pricePerMinute = 1.50; // Price per minute for parking.

    // initializes the parking garage with a certain amount of spots
    public ParkingGarage(int totalSpots) {
        this.availableSpots = totalSpots;
        this.tickets = new ArrayList<>();
    }

    // available parking space?
    public boolean hasAvailableSpots() {
        return availableSpots > 0;
    }

    // if there are spaces left, issues a ticket
    public Ticket issueTicket() {
        if (hasAvailableSpots()) {
            Ticket newTicket = new Ticket(tickets.size() + 1); // new ticket with unique ID generation
            tickets.add(newTicket); // ticket is added to list of tickets
            availableSpots--; // Number of available spaces -1
            return newTicket;
        }
        return null; // If no space available no ticket is issued
    }

    // exit of a car from parking garage
    public void exitGarage(Ticket ticket) {
        if (ticket.isPaid()) {
            availableSpots++; // When a car leaves +1 spot
            System.out.println("Car with Ticket ID: " + ticket.getTicketId() + " has exited the garage. Thank you!");
        } else {
            System.out.println("Car with Ticket ID: " + ticket.getTicketId() + " cannot exit. Please pay first.");
        }
    }

    // Parking fee calculation based on time spent 
    public double calculateParkingFee(Ticket ticket) {
        int currentTime = (int) System.currentTimeMillis(); // Gets the current time.
        int parkedTimeInMinutes = (currentTime - ticket.getEntryTime()) / (1000 * 60); // parked time in minutes
        return parkedTimeInMinutes * pricePerMinute; // returns the fee based on time parked
    }

    // Getter for available spots.
    public int getAvailableSpots() {
        return availableSpots;
    }
}
