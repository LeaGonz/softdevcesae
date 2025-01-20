package Ex03;

public class Marisco {
    private String especie;
    private double peso;
    private double precoKg;

    // construtor
    public Marisco(String especie, double peso, double precoKg) {
        this.especie = especie;
        this.peso = peso;
        this.precoKg = precoKg;
    }

    //Getters
    public double getPeso() {
        return this.peso;
    }

    public String getEspecie() {
        return this.especie;
    }
}
