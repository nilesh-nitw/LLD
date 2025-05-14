package question.parkinglot;


public class Payment {
    private final double amount;
    private final PaymentStatus status;

    public Payment(double amount, PaymentStatus status) {
        this.amount = amount;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
