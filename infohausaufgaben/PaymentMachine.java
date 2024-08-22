package infohausaufgaben;

// the payment machine
public class PaymentMachine {
    private ParkingGarage garage;

    // takes reference to the parkinggarage
    public PaymentMachine(ParkingGarage garage) {
        this.garage = garage;
    }

    // payment for a ticket
    public void pay(Ticket ticket) {
        double fee = garage.calculateParkingFee(ticket); // parking fee calculation
        System.out.printf("Car with Ticket ID: %d is paying a fee of €%.2f.\n", ticket.getTicketId(), fee);
        ticket.pay(); // ticket is payed
        System.out.println("Payment successful for Ticket ID: " + ticket.getTicketId());
    }
}
