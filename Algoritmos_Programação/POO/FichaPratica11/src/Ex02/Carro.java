package Ex02;

import Ex02.Enums.TipoCombustivel;

public class Carro extends Veiculo {
    private int quantidadePassageiros;

    // construtor
    public Carro(String marca, String modelo, int anoFabricacao, int potencia, int cc, TipoCombustivel combustivel, double litros100km, int quantidadePassageiros) {
        super(marca, modelo, anoFabricacao, potencia, cc, combustivel, litros100km);
        this.quantidadePassageiros = quantidadePassageiros;
    }

    /**
     * Metodo para calcular custo duma viagem, com base ao tipo de combustivel
     * @param km
     * @return
     */
    public double calcularCusto(double km) {
        double custo = 0;
        switch (this.combustivel) {
            case GASOLINA -> custo = 2.1;
            case DIESEL -> custo = 1.95;
            case GPL -> custo = 1.15;
            case ELETRICO -> custo = 0.12;
        }
        return this.consumo(km) * custo;
    }
}
