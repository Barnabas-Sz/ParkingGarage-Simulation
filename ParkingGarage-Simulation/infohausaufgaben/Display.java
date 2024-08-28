package infohausaufgaben;
// This code belongs to Barnabas Szelenyi 

// the display that shows available spots
public class Display {
    private ParkingGarage garage;

    // takes reference to the parking garage
    public Display(ParkingGarage garage) {
        this.garage = garage;
    }

    // shows the available spots
    public void showAvailableSpots() {
        System.out.println("Available spots: " + garage.getAvailableSpots());
    }
}
