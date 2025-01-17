package Ex01;

public class Main {
    public static void main(String[] args) {
        Carro ford = new Carro("Ford", "Mustang", 1964,
                300, 8, TipoCombustivel.GASOLINA, 10);
        Carro chevrolet = new Carro("Chevrolet", "Camaro", 1964,
                250, 8, TipoCombustivel.DIESEL, 7.4);
        Carro dodge = new Carro("Dodge", "Challenger", 2012,
                250, 8, TipoCombustivel.GASOLINA, 7.4);
        Carro fiat = new Carro("Fiat", "Punto", 2024,
                200, 8, TipoCombustivel.GASOLINA, 7.4);

        ford.ligar();
        chevrolet.ligar();
        dodge.ligar();
        fiat.ligar();

        System.out.println("---------------------------------------");

        System.out.println("Ganhou 1");
        ford.corrida(chevrolet).exibirDetalhes();
        System.out.println("Ganhou 2");
        dodge.corrida(fiat).exibirDetalhes();

        System.out.println("---------------------------------------");

        System.out.println("Consumo de: " + ford.consumo(97));
        System.out.println("Consumo de: " + chevrolet.consumo(97));
        if (ford.consumo(97) > chevrolet.consumo(97)) {
            System.out.println("O que mais consume: " + ford.getModelo() + " " + ford.consumo(97));
        } else {
            System.out.println("O que mais consume: " + chevrolet.getModelo() + " " + chevrolet.consumo(97));
        }
    }
}
