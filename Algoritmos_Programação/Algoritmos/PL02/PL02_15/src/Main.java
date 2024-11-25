import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        15. Refaça o exercício usando a estrutura PARA
         */
        Scanner numin = new Scanner(System.in);
        int num = 0;
        int i;
        for (i = 1; i <= 5; i++) {
            System.out.println("Insira o número "+ i +":");
            num = num + numin.nextInt();
        }
        System.out.println("A média aritmética do "+ num + " é = " + (num/(i-1)));
    }
}