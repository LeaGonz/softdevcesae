import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        26. Escreva um programa que converta um valor binário para decimal.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Inserir o número binário:");
        int bin = numin.nextInt();
        int dec = 0;
        int pos = 0;

        while (bin > 0){
            int ultimoDigito = bin % 10;

            dec += ultimoDigito * Math.pow(2, pos);
            pos++;
            bin /= 10;
        }
        System.out.println(dec);

        /*String bina = numin.nextLine();

        int len = bina.length() - 1;
        int expo = 1;
        int decimal = 0;

        for (int i = 0; i <= len; i++) {
            int bit = Integer.parseInt(bina.substring(i, i + 1));
            for (int j = 0; j < len - i; j++) {
                expo *= 2;
            }
            decimal += (bit * expo);
            expo = 1;
            // decimal += (bit * Math.pow(2, len - i));
        }
        System.out.println("O número decimal é: " + decimal);*/
        }
    }
