import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        6. Faça um programa que receba o valor do quilo de um produto e a quantidade
        de quilos do produto consumida calculando o valor final a ser pago.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Valor do quilo:");
        double valor = numin.nextDouble();

        System.out.println("Quantidade de quilos:");
        double quilos = numin.nextDouble();

        System.out.println("Valor a pagar por " + quilos + "KG: " + (valor * quilos));

        //sout = System.out.println();
    }
}