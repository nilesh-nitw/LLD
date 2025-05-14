package question.parkinglot;


import java.util.List;

public interface ParkingStrategy {
    Slot findSlot(List<Floor> floors, VehicleType type);
}