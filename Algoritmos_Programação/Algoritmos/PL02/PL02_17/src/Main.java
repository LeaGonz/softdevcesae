import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        17. Adapte o exercício anterior considerando que se a média obtida for maior que 8 deverá ser atribuída 10 para a
        média.
         */
        Scanner numin = new Scanner(System.in);
        int num = 0;
        int i = 1;
        int media;
        while (i <= 20){
            System.out.println("Insira o número "+ i +":");
            num = num + numin.nextInt();
            i++;
        }
        media = (num/(i-1));
        if (media > 8){
            System.out.println("A média aritmética é 10");

        } else {
            System.out.println("A média aritmética do "+ num + " é = " + media);
        }
    }
}