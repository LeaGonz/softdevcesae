import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        20. Crie um programa que permita converter um valor em dias para anos, semanas e dias.
         */
        Scanner numin = new Scanner(System.in);
        double dia;
        double ano;
        double semana;

        System.out.println("Insira a quantidade de dias:");
        dia = numin.nextDouble();

        if (dia >= 0){
            ano = dia / 365;
            semana = dia / 7;
            System.out.println(dia + " dias são " + ano + " anos e " + semana + " semanas.");
        } else {
            System.out.println("Dia no pode ser menor que cero.");
        }
    }
}