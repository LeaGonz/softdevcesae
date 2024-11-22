import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        22. Crie um programa que permita converter um valor em Megabytes para Bytes.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira a quantidade de Megabytes:");
        double megabytes = numin.nextDouble();
        if (megabytes >= 0){
            double bytes = megabytes * 1048576;
            System.out.println(megabytes + " Megabytes são " + bytes + " Bytes.");
        } else {
            System.out.println("A quantidade de Megabytes não pode ser negativo");
        }
    }
}