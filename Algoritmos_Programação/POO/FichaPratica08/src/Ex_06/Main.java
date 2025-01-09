package Ex_06;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Número 1: ");
        double n1 = in.nextDouble();
        System.out.println("Número 2: ");
        double n2 = in.nextDouble();

        Calculadora calculadora = new Calculadora();

        System.out.printf("Soma: %.2f\n", calculadora.somar(n1, n2));
        System.out.printf("Subtracao: %.2f\n", calculadora.subtrair(n1, n2));
        System.out.printf("Multiplicacao: %.2f\n", calculadora.multiplicar(n1, n2));
        System.out.printf("Divisao: %.2f\n", calculadora.dividir(n1, n2));
    }
}
