package Ex02;

import Ex02.Enums.TipoCombustivel;

public class Main {
    public static void main(String[] args) {
        Carro mustang = new Carro("Ford", "Mustang", 1964, 400, 100, TipoCombustivel.GASOLINA, 14.5, 5);
        Carro camaro = new Carro("Chevrolet", "Camaro", 1964, 500, 80, TipoCombustivel.DIESEL, 13, 5);

        Mota moto1 = new Mota("Kawasaki", "F-145", 2025, 500, 100, TipoCombustivel.DIESEL, 15);
        Mota moto2 = new Mota("Bera", "Beta", 2010, 150, 40, TipoCombustivel.GASOLINA, 8);

        Camiao camiao1 = new Camiao("Mercedez", "Ca1", 2023, 400, 40, TipoCombustivel.DIESEL, 8, 30000);
        Camiao camiao2 = new Camiao("Hansong", "Ca2", 2020, 450, 40, TipoCombustivel.DIESEL, 8, 50000);

        /* LIGAR */
        mustang.ligar();
        camaro.ligar();
        moto1.ligar();
        moto2.ligar();
        camiao1.ligar();
        camiao2.ligar();
        System.out.println();

        /* CORRIDA */
        System.out.println("_*_*_*_*_* CORRIDA 1 - " + mustang.getModelo() + " Vs " + camaro.getModelo() + " _*_*_*_*_*");
        System.out.println("Ganhou: " + mustang.corrida(camaro).getModelo());
        System.out.println("_*_*_*_*_* CORRIDA 2 - " + moto1.getModelo() + " Vs " + camiao1.getModelo() + " _*_*_*_*_*");
        System.out.println("Ganhou: " + moto1.corrida(camiao1).getModelo());
        System.out.println();

        /* CONSUMO */
        System.out.println("Numa viagem de 150km o " + mustang.getModelo() + " consume: " + mustang.consumo(150) + "lts");
        System.out.println();

        /* CALCULAR CUSTO CARRO */
        System.out.println("A viagem de 150km com o " + mustang.getModelo() + " custa: " + mustang.calcularCusto(150) + "€");
        System.out.println("A viagem de 150km com o " + camaro.getModelo() + " custa: " + camaro.calcularCusto(150) + "€");
        System.out.println();

        /* IMPRIMIR MOTA */
        moto1.imprimirMota();
        moto2.imprimirMota();
        System.out.println();

        /* VIAGEM VALIDA / INVALIDA */
        camiao1.viagem(150, 500);
        camiao2.viagem(100, 10000000);
    }
}
