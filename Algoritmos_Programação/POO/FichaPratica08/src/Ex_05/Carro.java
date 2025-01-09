package Ex_05;

public class Carro {
    // Atributos
    private String marca;
    private String modelo;
    private int anoFabricacao;

    // Metodo construtor
    Carro(String marca, String modelo, int anoFabricacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    // Metodos de instâncias
    public void ligar() {
        System.out.println("O carro " + this.marca + " está ligado");
    }
}
