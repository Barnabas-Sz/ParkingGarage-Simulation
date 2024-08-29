// This code belongs to Barnabas Szelenyi

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private ParkingGarage garage;
    private EntranceGate entranceGate;
    private ExitGate exitGate;
    private PaymentMachine paymentMachine;
    private Display display;

    public Simulation(int numberOfSpots) {
        this.garage = new ParkingGarage(numberOfSpots);
        this.entranceGate = new EntranceGate(garage);
        this.exitGate = new ExitGate(garage);
        this.paymentMachine = new PaymentMachine(garage);
        this.display = new Display(garage);
    }

    public void run() {
        List<Ticket> tickets = new ArrayList<>();

        // Cars entering the garage
        for (int i = 0; i < garage.getAvailableSpots(); i++) {
            System.out.println("\n--- Car " + (i + 1) + " is entering the garage ---");
            Ticket ticket = entranceGate.enter();
            if (ticket != null) {
                tickets.add(ticket);
                display.showAvailableSpots();
            }
        }

        // simulate 2 seconds of time passing for fee calc
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
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