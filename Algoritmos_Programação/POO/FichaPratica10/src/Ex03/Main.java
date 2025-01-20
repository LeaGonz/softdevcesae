package Ex03;

public class Main {
    public static void main(String[] args) {
        BarcoPesca barcoPesca = new BarcoPesca("Sunny", "vermelho", "1991",
                8, 200, Marca.Quicksilver);
        Peixe salmon = new Peixe("Salmon",150,10.2);
        Marisco calamar = new Marisco("Calamar",85,15.8);

        barcoPesca.pescarPeixe(salmon);
        System.out.println();
        barcoPesca.pescarMarisco(calamar);
    }
}