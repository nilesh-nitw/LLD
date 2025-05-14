package question.parkinglot;

public class Vehicle {
    private String vehicleNumber;
    private VehicleType type;

    public Vehicle(String number, VehicleType type) {
        this.vehicleNumber = number;
        this.type = type;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public VehicleType getType() { return type; }
}