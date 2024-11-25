import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        10. Faça um programa que verifique se um número é ímpar.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Número 1:");
        int n1 = numin.nextInt();

        if ((n1%2) == 0){
            System.out.println("O número " + n1 + " é par.");
        } else {
            System.out.println("O número " + n1 + " é ímpar.");
        }
    }
}