import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        20. Crie um programa que permita converter um valor em dias para anos, semanas e dias.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira a quantidade de dias:");
        int dias = numin.nextInt();

        if (dias >= 0){
            int ano = dias / 365;
            int resto = dias % 365;
            int semana = resto / 7;
            int dia = resto % 7;
            System.out.println(dias + " dias são " + ano + " anos, " + semana + " semanas. e " + dia + " dias.");
        } else {
            System.out.println("Dia no pode ser menor que cero.");
        }
    }
}