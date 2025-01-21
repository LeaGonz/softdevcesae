package Ex03;

public class Main {
    public static void main(String[] args) {
        BarcoPesca barcoPesca = new BarcoPesca("Sunny", "vermelho", "1991",
                8, 200, Marca.Quicksilver);
        Peixe salmon = new Peixe("Salmon",70,10.2);
        Marisco calamar = new Marisco("Calamar",85,15.8);

        barcoPesca.pescarPeixe(salmon);
        System.out.println();
        barcoPesca.pescarMarisco(calamar);
        System.out.println();

        barcoPesca.largarPeixe(salmon);
        barcoPesca.mostrarPeso();
        barcoPesca.pescarMarisco(calamar);
        barcoPesca.largarMarisco(calamar);
        barcoPesca.mostrarPeso();
        System.out.println();
        barcoPesca.calcularTotal();
        System.out.println("-----------------");
        barcoPesca.salarioTripulacao();
    }
}