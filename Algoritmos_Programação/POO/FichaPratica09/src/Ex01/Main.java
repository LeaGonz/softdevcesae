package Ex01;

public class Main {
    public static void main(String[] args) {
        Carro ford = new Carro("Ford", "Mustang", 1964,
                300, 8, Carro.TipoCombustivel.GASOLINA, 10);
        Carro chevrolet = new Carro("Chevrolet", "Camaro", 1964,
                250, 8, Carro.TipoCombustivel.DIESEL, 7.4);
        Carro dodge = new Carro("Dodge", "Challenger", 2012,
                250, 8, Carro.TipoCombustivel.GASOLINA, 7.4);
        Carro fiat = new Carro("Fiat", "Punto", 2024,
                200, 8, Carro.TipoCombustivel.GASOLINA, 7.4);

        ford.ligar();
        chevrolet.ligar();
        dodge.ligar();
        fiat.ligar();
    }
}
