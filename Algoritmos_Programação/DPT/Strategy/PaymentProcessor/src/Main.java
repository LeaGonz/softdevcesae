//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor(new NoDiscountStrategy());
        double total = paymentProcessor.calculateTotal(100.0);
        System.out.println("Total sem desconto: " + total);

        paymentProcessor = new PaymentProcessor(new FlatDiscountStrategy(10.0));
        total = paymentProcessor.calculateTotal(100.0);
        System.out.println("Total com desconto fixo: " + total);

        paymentProcessor = new PaymentProcessor(new PercentageDiscountStrategy(0.2));
        total = paymentProcessor.calculateTotal(100.0);
        System.out.println("Total com desconto percentual: " + total);
    }
}
