import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        26. Escreva um programa que converta um valor binário para decimal.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Inserir o número binário:");
        String bina = numin.nextLine();

        int len = bina.length() - 1;
        int decimal = 0;
        int expo = 1;

        for (int i = 0; i <= len; i++) {
            int bit = Integer.parseInt(bina.substring(i, i + 1));
            for (int j = 0; j < len - i; j++) {
                expo *= 2;
            }
            decimal += (bit * expo);
            expo = 1;
            // decimal += (bit * Math.pow(2, len - i));
        }
        System.out.println("O número decimal é: " + decimal);
        }
    }
