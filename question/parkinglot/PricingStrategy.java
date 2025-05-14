package question.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculateFee(VehicleType type, LocalDateTime entry, LocalDateTime exit);
}
