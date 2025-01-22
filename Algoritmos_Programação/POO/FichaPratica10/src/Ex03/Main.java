package Ex03;

public class Main {
    public static void main(String[] args) {
        BarcoPesca barcoPesca = new BarcoPesca("Sunny", "vermelho",
                1991, 8, 200, Marca.Quicksilver);
        Peixe salmon = new Peixe("Salmon", 70, 10.2);
        Marisco calamar = new Marisco("Calamar", 85, 15.8);

        barcoPesca.pescar(salmon);
        System.out.println();
        barcoPesca.pescar(calamar);
        System.out.println();

        barcoPesca.largarPeixe(salmon);
        barcoPesca.mostrarPeso();
        barcoPesca.pescar(calamar);
        barcoPesca.largarMarisco(calamar);
        barcoPesca.mostrarPeso();
        System.out.println();
        System.out.println("Total euros: " + barcoPesca.calcularTotal());
        System.out.println("-----------------");
        barcoPesca.salarioTripulacao();
    }
}