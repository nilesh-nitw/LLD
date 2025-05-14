package question.parkinglot;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingService {
    private final List<Floor> floors;
    private final ParkingStrategy parkingStrategy;
    private final PricingStrategy pricingStrategy;
    private final Map<String, Ticket> ticketMap = new HashMap<>();

    public ParkingService(List<Floor> floors, ParkingStrategy strategy, PricingStrategy pricingStrategy) {
        this.floors = floors;
        this.parkingStrategy = strategy;
        this.pricingStrategy = pricingStrategy;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        Slot slot = parkingStrategy.findSlot(floors, vehicle.getType());
        if (slot == null) throw new RuntimeException("No slot available");

        slot.park(vehicle);
        Ticket ticket = new Ticket(vehicle, slot);
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }

    public Payment unparkVehicle(String ticketId) {
        Ticket ticket = ticketMap.get(ticketId);
        if (ticket == null) throw new RuntimeException("Invalid ticket");

        Slot slot = ticket.getSlot();
        LocalDateTime exitTime = LocalDateTime.now();
        double fee = pricingStrategy.calculateFee(ticket.getVehicle().getType(), ticket.getEntryTime(), exitTime);

        slot.unpark();
        ticketMap.remove(ticketId);
        return new Payment(fee, PaymentStatus.COMPLETED);
    }

    public void displayAvailableSlots() {
        for (Floor floor : floors) {
            System.out.println("Floor " + floor.getNumber() + ":");
            for (Slot slot : floor.getSlots()) {
                if (slot.isAvailable()) {
                    System.out.println("  Slot " + slot.getId() + " (" + slot.getType() + ")");
                }
            }
        }
    }
}
