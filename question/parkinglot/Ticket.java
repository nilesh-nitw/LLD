package question.parkinglot;
import java.time.LocalDateTime;
import java.util.*;

public class Ticket {
    private final String id;
    private final Vehicle vehicle;
    private final Slot slot;
    private final LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, Slot slot) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }

    public String getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public Slot getSlot() { return slot; }
    public LocalDateTime getEntryTime() { return entryTime; }
}
