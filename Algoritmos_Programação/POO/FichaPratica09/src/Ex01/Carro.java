package Ex01;

public class Carro {
    // Atributos
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int potencia;
    private int cc;
    private TipoCombustivel combustivel;
    private double litros100km;

    // Metodo construtor
    Carro(String marca, String modelo, int anoFabricacao, int potencia, int cc,
          TipoCombustivel combustivel, double litros100km) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.potencia = potencia;
        this.cc = cc;
        this.combustivel = combustivel;
        this.litros100km = litros100km;
    }
    // GET
    public String getModelo() {
        return this.modelo;
    }

    // Metodos de instâncias
    public void ligar() {
        int idade = 2025 - this.anoFabricacao;
        if (idade > 30) { // Mais 30 anos
            if (this.combustivel.equals(TipoCombustivel.DIESEL)) {
                System.out.println("Deita um pouco de fumo… Custa a pegar… O carro está ligado!\n" +
                        "Vrum-vrum-vrum");
            } else {
                System.out.println("“Custa a pegar… O carro está ligado!\n" +
                        "Vrum-vrum-vrum");
            }
        } else { // 30 anos o mais recente
            if (this.potencia < 250) {
                System.out.println("O carro está ligado!\n" +
                        "Vruummmmmmm");
            } else {
                System.out.println("O carro está ligado!\n" +
                        "VRUUMMMMMM");
            }
        }
    }

    public Carro corrida(Carro adversario) {
        if (this.potencia > adversario.potencia) { // Ganha this
            return this;
        } else if (this.potencia < adversario.potencia) { // Ganha adversario
            return adversario;
        } else { // Empate
            if (this.cc > adversario.cc) { // Ganha this
                return this;
            } else if (this.cc < adversario.cc) { // Ganha adversario
                return adversario;
            } else { // Empate
                if (this.anoFabricacao > adversario.anoFabricacao) { // This
                    return this;
                } else if (this.anoFabricacao < adversario.anoFabricacao) { // Adversario
                    return adversario;
                } else {
                    return null; // Empate
                }
            }
        }
    }

    public double consumo(double km) {
        return (km * this.litros100km) / 100;
    }

    public void exibirDetalhes() {
        System.out.println("Marca: " + this.marca + " Modelo: " + this.modelo + " Ano: " + this.anoFabricacao);
    }
}
