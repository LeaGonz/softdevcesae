import javax.print.attribute.standard.JobKOctets;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        26. Escreva um programa que converta um valor binário para decimal.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Inserir o número binário:");
        String bina = numin.nextLine();
        //System.out.println(bina.length());
        int caract;

            for (int i = 1; i < bina; i--){
              caract = Integer.parseInt(String.valueOf(bina.charAt(i)));
              System.out.println(caract);
            }
        }
    }
