import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        1. Faça um programa que peça ao utilizador três notas, guarde-as num vetor e apresente a média final lendo as
        notas do vetor.
        */
        Scanner in = new Scanner(System.in);
        double[] notas = new double[3];
        double soma = 0;
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Insira a nota: " + (i + 1));
            notas[i] = in.nextDouble();
            soma += notas[i];
        }
        System.out.println("A média das notas é: " + (soma / notas.length));
    }
}