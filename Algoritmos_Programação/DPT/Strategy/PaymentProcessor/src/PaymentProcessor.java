public class PaymentProcessor {
    private DiscountStrategy strategy;

    public PaymentProcessor(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateTotal(double amount) {
        return this.strategy.calculateTotal(amount);
    }
}
