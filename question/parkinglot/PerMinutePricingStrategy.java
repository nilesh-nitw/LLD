package question.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class PerMinutePricingStrategy implements PricingStrategy {
    @Override
    public double calculateFee(VehicleType type, LocalDateTime entry, LocalDateTime exit) {
        long minutes = Duration.between(entry, exit).toMinutes();
        if (minutes == 0) minutes = 1;

        switch (type) {
            case BIKE: return minutes * 0.25;
            case CAR: return minutes * 0.5;
            case TRUCK: return minutes * 1.0;
            default: throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
