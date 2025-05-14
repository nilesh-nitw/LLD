package question.parkinglot;


import java.util.*;

public class NearestFirstParkingStrategy implements ParkingStrategy {

    @Override
    public Slot findSlot(List<Floor> floors, VehicleType type) {
        SlotType requiredSlot = SlotType.valueOf(type.name());

        for (Floor floor : floors) {
            for (Slot slot : floor.getSlots()) {
                if (slot.getType() == requiredSlot && slot.isAvailable()) {
                    return slot;
                }
            }
        }
        return null;
    }
}