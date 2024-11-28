import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int op = 1;
        do {
            System.out.println("** Jogo adivinhar o número **");
            System.out.println("Indique o nível do jogo:");
            System.out.println("1- Nível Fácil");
            System.out.println("2- Nível Médio");
            System.out.println("3- Nível Deus");
            System.out.println("0- Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1, 2, 3:
                    niveis(op);
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (op != 0);
    }

    private static void niveis(int op) {
        int n, i = 1, num_ale = rnd.nextInt(1, 21);
        // System.out.println("Número aleatorio" + num_ale);
        if (op == 1) {
            System.out.println("Nível Fácil");
        } else if (op == 2) {
            System.out.println("Nível Médio - Tem apenas 3 tentativas.");
        } else {
            System.out.println("Nível Deus");
        }
        do {
            System.out.print("Número: ");
            n = in.nextInt();

            switch (op) {
                case 1:
                    if (n > num_ale) System.out.println("Tente um número menor");
                    else if (n < num_ale) System.out.println("Tente um número maior");
                    else if (n == num_ale) System.out.println("Correto! Acertou em " + i + " tentativas.\n");
                    break;
                case 2:
                    if (i < 3) {
                        if (n > num_ale) System.out.println("Tente um número menor");
                        else if (n < num_ale) System.out.println("Tente um número maior");
                        else if (n == num_ale) System.out.println("Correto! Acertou em " + i + " tentativas.\n");
                    } else {
                        System.out.println("Alcançou o número máximo de tentativas. O número era: " + num_ale + "\n");
                        n = num_ale;
                    }
                    break;
                case 3:
                    if (n == num_ale) {
                        System.out.println("Correto! Acertou em " + i + " tentativas.\n");
                    } else if (n <= (num_ale + 2) && n >= (num_ale - 2)) {
                        System.out.println("O número está perto do correto.");
                    } else if (n <= (num_ale + 5) && n >= (num_ale - 5)) {
                        System.out.println("O número está nem longe nem perto do correto.");
                    } else {
                        System.out.println("O número está longe do correto.");
                    }
            }
            i++;
        } while (n != num_ale);
    }
}