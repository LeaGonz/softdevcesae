public class FlatDiscountStrategy implements DiscountStrategy {
    private double desconto;

    public FlatDiscountStrategy(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public double calculateTotal(double preco) {
        return preco - desconto;
    }
}
