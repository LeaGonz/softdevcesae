public class NoDiscountStrategy implements DiscountStrategy {

    public NoDiscountStrategy() {
    }

    @Override
    public double calculateTotal(double preco) {
        return preco;
    }
}
