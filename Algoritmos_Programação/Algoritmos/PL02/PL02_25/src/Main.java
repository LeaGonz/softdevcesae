import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        25. Elabore uma função que dado um ano verifique se ele é ou não bissexto.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira o ano:");
        int ano = numin.nextInt();

        if ((ano % 4 == 0) && (ano % 100 != 0 || ano % 400 == 0))
            System.out.println("Ano " + ano + " é bissexto");
         else
            System.out.println("Ano " + ano + " não é bissexto");

        /*
        if (ano % 4 == 0 ){
            if (ano % 100 == 0){
                if (ano % 400 == 0){
                    System.out.println("Ano " + ano + " é bissexto");
                } else {
                    System.out.println("Ano " + ano + " não é bissexto");
                }
            } else {
                System.out.println("Ano " + ano + " é bissexto");
            }
        } else {
            System.out.println("Ano " + ano + " não é bissexto");
        }*/
    }
}