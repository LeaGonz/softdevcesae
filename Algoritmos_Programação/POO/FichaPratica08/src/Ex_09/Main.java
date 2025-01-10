package Ex_09;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Cafe", 2.5);

        p1.Comprar(5);
        p1.Vender(2);
        p1.Comprar(10);
        p1.Vender(35);
    }
}
