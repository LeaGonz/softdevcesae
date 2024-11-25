import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        16. Dado uma série de 20 valores inteiros, faça um algoritmo que calcule e escreva a média aritmética destes valores.
         */
        Scanner numin = new Scanner(System.in);
        int num = 0;
        int i = 1;
        while (i <= 20){
            System.out.println("Insira o número "+ i +":");
            num = num + numin.nextInt();
            i++;
        }
        System.out.println("A média aritmética do "+ num + " é = " + (num/(i-1)));
    }
}