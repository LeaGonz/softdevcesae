public class PercentageDiscountStrategy implements DiscountStrategy {
    private double desconto;

    public PercentageDiscountStrategy(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public double calculateTotal(double preco) {
        return preco-((preco * desconto) / 100);
    }
}


