package Ex03;

public class Peixe {
    private String especie;
    private double peso;
    private double precoKg;

    /**
     * Metodo construtor de <b>Peixe</b>
     * @param especie
     * @param peso (KG)
     * @param precoKg
     */
    public Peixe(String especie, double peso, double precoKg) {
        this.especie = especie;
        this.peso = peso;
        this.precoKg = precoKg;
    }

    // Getters
    public double getPeso() {
        return peso;
    }

    public String getEspecie() {
        return this.especie;
    }

    public double getPrecoKg() {
        return precoKg;
    }
}
