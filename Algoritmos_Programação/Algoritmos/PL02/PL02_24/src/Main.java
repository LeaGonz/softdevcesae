import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        24. Ler N números, determinar o maior, o menor e a média dos N números lidos.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira a quantidade de números a calcular:");
        int n = numin.nextInt();
        if (n <= 0) {
            System.out.println("O número deve ser maior a zero.");
            return;
        }

        double menor = 0, maior = 0, soma = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("Número " + i + " :");
            double valor = numin.nextDouble();
            soma += valor;

            if (i == 1) {
                menor = valor;
                maior = valor;
            }
            if (valor < menor) {
                menor = valor;
            }
            if (valor > maior) {
                maior = valor;
            }
        }
        System.out.println("O número maior é: " + maior + ", o menor é: " + menor + " e a média é: " + (soma/n));

    }
}