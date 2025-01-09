package Ex_06;

public class Calculadora {
    // Sem atributos

    // Metodos de instâncias
    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b != 0)
            return a / b;
        else
            System.out.println("Erro: Divisão por zero não é permitida.");
        return 0;
    }
}
