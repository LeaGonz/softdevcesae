import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        21. Crie um programa que permita converter um valor em bytes para bits.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira a quantidade de bytes:");
        double bytes = numin.nextDouble();
        if (bytes >= 0){
            double bits = bytes * 8;
            System.out.println(bytes + " bytes são " + bits + " bits.");
        } else {
            System.out.println("A quantidade de bytes não pode ser negativo");
        }
    }
}