package question.parkinglot;

import java.util.*;

public class ParkingLotApp {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose pricing strategy (simple/hourly/perminute): ");
        String strategyType = scanner.nextLine();

        PricingStrategy pricingStrategy;
        try {
            pricingStrategy = PricingStrategyFactory.getStrategy(strategyType);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid strategy. Defaulting to simple.");
            pricingStrategy = new SimplePricingStrategy();
        }

        List<Floor> floors = new ArrayList<>();

        // Create floor 0 with 2 car slots and 1 bike slot
        Floor floor0 = new Floor(0);
        floor0.addSlot(new Slot(1, SlotType.CAR));
        floor0.addSlot(new Slot(2, SlotType.CAR));
        floor0.addSlot(new Slot(3, SlotType.BIKE));
        floor0.addSlot(new Slot(4, SlotType.BIKE));
        floor0.addSlot(new Slot(5, SlotType.BIKE));
        floor0.addSlot(new Slot(2, SlotType.CAR));

        floors.add(floor0);

        ParkingService service = new ParkingService(
                floors,
                new NearestFirstParkingStrategy(),
                pricingStrategy
        );

        Vehicle car = new Vehicle("MH12AB1234", VehicleType.CAR);
        Vehicle bike = new Vehicle("MH12CD5678", VehicleType.BIKE);

        Ticket ticket1 = service.parkVehicle(car);
        Ticket car2 = service.parkVehicle(car);
        //Ticket car3 = service.parkVehicle(car);
        Ticket ticket2 = service.parkVehicle(bike);
        Ticket ticket3 = service.parkVehicle(bike);

        System.out.println("Tickets issued:");
        System.out.println(ticket1.getId());
        System.out.println(ticket2.getId());
        System.out.println(ticket3.getId());

        Payment pay1 = service.unparkVehicle(ticket3.getId());
        System.out.println("pay1 " +pay1.getAmount());

        service.displayAvailableSlots();

        Thread.sleep(2000); // simulate time passage

        Payment payment = service.unparkVehicle(ticket1.getId());
        System.out.println("Payment for car: " + payment.getAmount());
    }
}
