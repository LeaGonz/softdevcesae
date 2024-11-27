import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        int num_ale = rnd.nextInt(1, 51);
        System.out.println(num_ale);
        int n, i = 0;

        System.out.println("** Adivinhe o número **");
        do {
            System.out.print("Número: ");
            n = in.nextInt();

            if (n > num_ale) System.out.println("Tente um número menor");
            else if (n < num_ale) System.out.println("Tente um número maior");

            i++;
        } while (n != num_ale);
        System.out.println("Acertou em " + i + " tentativas.");
    }
}