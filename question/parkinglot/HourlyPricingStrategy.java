package question.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculateFee(VehicleType type, LocalDateTime entry, LocalDateTime exit) {
        long hours = Duration.between(entry, exit).toHours();
        if (hours == 0) hours = 1;

        switch (type) {
            case BIKE: return hours * 15;
            case CAR: return hours * 25;
            case TRUCK: return hours * 40;
            default: throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
