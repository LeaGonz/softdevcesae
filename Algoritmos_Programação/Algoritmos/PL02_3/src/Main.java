import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        3. Crie um algoritmo que após ler dois números inteiros apresenta a sua diferença.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Número 1: ");
        int n1 = numin.nextInt();

        System.out.println("Número 2: ");
        int n2 = numin.nextInt();

        System.out.println("A diferença é: " + (n1 - n2));
    }
}