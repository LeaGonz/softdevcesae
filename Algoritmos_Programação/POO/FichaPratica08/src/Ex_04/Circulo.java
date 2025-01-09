package Ex_04;

public class Circulo {
    // Atributos
    private double raio;

    // Metodo Construtor
    Circulo(double raio) {
        this.raio = raio;
    }

    // Metodo de instâncias
    public double area() {
        return (Math.PI * Math.pow(this.raio, 2));
    }

    public double circunferencia() {
        return (2 * Math.PI * this.raio);
    }

    // Getters

    // Setters
}
