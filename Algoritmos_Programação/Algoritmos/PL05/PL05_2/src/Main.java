import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int op = 1, count = 0;
        do {
            System.out.println("** Jogo de adivinhar o número **");
            System.out.println("Indique o nível do jogo:");
            System.out.println("1- Nível Fácil");
            System.out.println("2- Nível Médio");
            System.out.println("3- Nível Deus");
            System.out.println("0- Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    NivelFacil();
                    break;
                case 2:
                    NivelMedio();
                    break;
                case 3:
                    NivelDeus();
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (op != 0);
    }

    private static void NivelFacil() {
        int i = 0, n;
        int num_ale = rnd.nextInt(1, 21);
        System.out.println("Nível Fácil");
        System.out.println(num_ale);

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

    private static int NivelMedio() {
        System.out.println("Nível Médio");
        return 0;
    }

    private static int NivelDeus() {
        System.out.println("Nível Deus");
        return 0;
    }
}