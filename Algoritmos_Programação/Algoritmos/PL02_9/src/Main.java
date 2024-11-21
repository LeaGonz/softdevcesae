import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        9. Faça um programa que receba 4 valores e retorne o menor entre eles.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Número 1:");
        int n1 = numin.nextInt();

        System.out.println("Número 2:");
        int n2 = numin.nextInt();

        System.out.println("Número 3:");
        int n3 = numin.nextInt();

        System.out.println("Número 4:");
        int n4 = numin.nextInt();

        if (n1 < n2 && n1 < n3 && n1 < n4){
            System.out.println("Número 1: " + n1 + " é o menor.");
        } else if (n2 < n3 && n2 < n4) {
            System.out.println("Número 2: " + n2 + " é o menor");
        } else if (n3 < n4) {
            System.out.println("Número 3: " + n3 + " é o menor");
        } else {
            System.out.println("Número 4: " + n4 + " é o menor");
        }
    }
}