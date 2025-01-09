package Ex_09;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Cafe", 2.5, 50);
        Produto p2 = new Produto("Pão", 1.5, 25);

        p1.Comprar(45);
        p2.Comprar(13);
    }
}
