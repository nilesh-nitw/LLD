package question.parkinglot;

public class PricingStrategyFactory {

    public static PricingStrategy getStrategy(String type) {
        switch (type.toLowerCase()) {
            case "simple":
                return new SimplePricingStrategy();
            case "hourly":
                return new HourlyPricingStrategy();
            case "perminute":
                return new PerMinutePricingStrategy();
            default:
                throw new IllegalArgumentException("Unknown strategy type: " + type);
        }
    }
}
