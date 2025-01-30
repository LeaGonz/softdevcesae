package Ex02;

import Ex02.Enums.TipoCombustivel;

public class Camiao extends Veiculo {
    private double capacidadeCarga;

    // construtor
    public Camiao(String marca, String modelo, int anoFabricacao, int potencia, int cc, TipoCombustivel combustivel, double litros100km, double capacidadeCarga) {
        super(marca, modelo, anoFabricacao, potencia, cc, combustivel, litros100km);
        this.capacidadeCarga = capacidadeCarga;
    }

    public void viagem(double km, double carga) {
        if (carga > this.capacidadeCarga) {
            System.out.println("Viagem recusada, a carga é maior do que a capacidade do camião.");
        } else {
            double consumo = this.consumo(km) + ((carga / 100) * 0.1);
            System.out.println(this.getModelo() + " consumiu " + consumo + "lts, e o custo total da viagem é de " + (consumo * 1.95) + "€");
        }
    }
}
