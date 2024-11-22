import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        24. Ler N números, determinar o maior, o menor e a média dos N números lidos.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira a quantidade de números a calcular:");
        int n = numin.nextInt();

        int valor;
        int menor = 0;
        int maior = 0;
        double soma = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("Número " + i + " :");
            valor = numin.nextInt();
            soma += valor;

            if (menor == 0){
                menor = valor;
            } else if(valor < menor) {
                menor = valor;
            }

            if (maior == 0){
                maior = valor;
            } else if(valor > maior) {
                maior = valor;
            }
        }
        System.out.println("O número maior é: " + maior + ", o menor é: " + menor + " e a média é: " + (soma/n));

    }
}