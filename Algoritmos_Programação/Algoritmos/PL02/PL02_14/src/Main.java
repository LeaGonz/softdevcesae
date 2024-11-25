import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        14. Faça um programa que utilize a estrutura ENQUANTO para ler 5 números e calcule e exiba a média aritmética
            deles.
         */
        /*
        for (int i = 1; i <= 100; i++){
            System.out.println(i);
        int i = 1;
        while (i <= 10){
            System.out.println(i);
            i++;
        }
        }*/
        Scanner numin = new Scanner(System.in);
        int num = 0;
        int i = 1;
        while (i <= 5){
            System.out.println("Insira o número "+ i +":");
            num = num + numin.nextInt();
            i++;
        }
        System.out.println("A média aritmética do "+ num + " é = " + (num/(i-1)));
    }
}