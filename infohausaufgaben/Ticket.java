package infohausaufgaben;
// This code belongs to Barnabas Szelenyi 

// the parking ticket
public class Ticket {
    private boolean isPaid;
    private int entryTime;
    private int ticketId;

    // parking ticket with unique ID is created
    public Ticket(int id) {
        this.ticketId = id;
        this.isPaid = false; // first, the ticket is not paid
        this.entryTime = System.currentTimeMillis(); // time the car entered in milliseconds
    }

    // Getter for the paid status.
    public boolean isPaid() {
        return isPaid;
    }

    // Marks the ticket as paid.
    public void pay() {
        this.isPaid = true;
    }

    // Getter for the entry time.
    public int getEntryTime() {
        return entryTime;
    }

    // Getter for the ticket ID.
    public int getTicketId() {
        return ticketId;
    }
}
