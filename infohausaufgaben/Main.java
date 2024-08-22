package infohausaufgaben;

import java.util.ArrayList;
import java.util.List;

// Main class / runs the sim
public class Main {
    public static void main(String[] args) {
        ParkingGarage garage = new ParkingGarage(5); // 5 spots in the garage
        EntranceGate entranceGate = new EntranceGate(garage);
        ExitGate exitGate = new ExitGate(garage);
        PaymentMachine paymentMachine = new PaymentMachine(garage);
        Display display = new Display(garage);

        // 5 cars enter, pay, then exit
        List<Ticket> tickets = new ArrayList<>();

        // Cars entering the garage
        for (int i = 0; i < 5; i++) {
            System.out.println("\n--- Car " + (i + 1) + " is entering the garage ---");
            Ticket ticket = entranceGate.enter();
            if (ticket != null) {
                tickets.add(ticket);
                display.showAvailableSpots();
            }
        }

        // simulate 2 seconds of time passing for fee calc
        try {
            Thread.sleep(2000); // 
        } catch (InterruptedException e) { // exception handling
            e.printStackTrace();
        }

        // cars pay and exit
        for (Ticket ticket : tickets) {
            System.out.println("\n--- Car with Ticket ID: " + ticket.getTicketId() + " is paying and exiting ---");
            paymentMachine.pay(ticket);
            exitGate.exit(ticket);
            display.showAvailableSpots();
        }
    }
}
