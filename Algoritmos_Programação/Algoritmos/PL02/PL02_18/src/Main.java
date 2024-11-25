import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        18. Dado um conjunto de n números inteiros inseridos pelo utilizador, faça um algoritmo que calcule a média dos
           valores maiores que 4.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira a quantidade de números a calcular:");
        int n = numin.nextInt();
        //int num = 0;
        int num;
        double soma = 0;
        int divi = 0;

        for (int i = 1; i <= n; i++){
            System.out.println("Insira o valor " + i + ":");
            num = numin.nextInt();
            if (num > 4){
                soma += num;
                divi++;
            }
        }
        System.out.println("A media do "+ soma +" é: " + (soma / divi));

        /* do {
            System.out.println("Insira um valor. Insira 0 para parar");
            num = numin.nextInt();
        } while (num != 0);*/
    }
}