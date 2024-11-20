import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        8. Faça um programa que receba 2 valores e retorne o maior entre eles.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira um numero 1: ");
        int nu1 = numin.nextInt();

        System.out.println("Insira um numero 2: ");
        int nu2 = numin.nextInt();

        if (nu1 > nu2){
            System.out.println("O número " + nu1 + " é maior que "+ nu2);
        } else if (nu1 < nu2) {
            System.out.println("O número " + nu2 + " é maior que "+ nu1);
        } else {
            System.out.println("Os números são iguais");
        }
    }
}