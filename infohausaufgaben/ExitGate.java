package infohausaufgaben;
// This code belongs to Barnabas Szelenyi 

// the exit gate
public class ExitGate {
    private ParkingGarage garage;

    // references the parkinggarage
    public ExitGate(ParkingGarage garage) {
        this.garage = garage;
    }

    // Car exiting garage
    public void exit(Ticket ticket) {
        garage.exitGarage(ticket); // Calls the exitfunktion in garage
    }
}
