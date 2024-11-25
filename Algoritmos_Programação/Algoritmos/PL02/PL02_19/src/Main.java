import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        19. Crie um programa que permita converter um valor em horas para segundos e mostre o valor em segundos.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira a hora a converter para segundos:");
        int hora = numin.nextInt();
        if (hora >= 0){
            int seg = hora * 3600;
            System.out.println(hora + " horas são " + seg + " segundos." );
        } else {
            System.out.println("Hora não pode ser negativo.");
        }
    }
}