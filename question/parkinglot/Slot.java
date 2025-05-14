package question.parkinglot;

public class Slot {
    private final int id;
    private final SlotType type;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public Slot(int id, SlotType type) {
        this.id = id;
        this.type = type;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void park(Vehicle v) {
        this.parkedVehicle = v;
        this.isOccupied = true;
    }

    public void unpark() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public SlotType getType() { return type; }

    public int getId() {
        return id;
    }
}
