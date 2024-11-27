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
                    NivelFacil(op);
                    break;
                case 2:
                    NivelMedio(op);
                    break;
                case 3:
                    NivelDeus(op);
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (op != 0);
    }

    private static void niveis(int op) {
        int n, i = 1, num_ale = rnd.nextInt(1, 21);
        System.out.println(num_ale);
        do {
            System.out.print("Número: ");
            n = in.nextInt();

            switch (op) {
                case 1:
                    if (n > num_ale) System.out.println("Tente um número menor");
                    else if (n < num_ale) System.out.println("Tente um número maior");
                    else if (n == num_ale) System.out.println("Acertou em " + i + " tentativas.");
                    break;
                case 2:
                    if (i < 3) {
                        if (n > num_ale) System.out.println("Tente um número menor");
                        else if (n < num_ale) System.out.println("Tente um número maior");
                        else if (n == num_ale) System.out.println("Acertou em " + i + " tentativas.");
                    } else {
                        System.out.println("Alcançou o número máximo de tentativas. O número era: " + num_ale);
                        n = num_ale;
                    }
                    break;
                case 3:
                    if (n <= (num_ale + 2) && n >= (num_ale - 2)) {
                        System.out.println("O número está perto do correto.");
                    } else if ((n <= (num_ale + 5) && n > (num_ale + 2)) || (n >= (num_ale - 5) && n > (num_ale - 2))) {
                        System.out.println("O número está nem longe nem perto do correto.");
                    } else if (n > (num_ale + 5) && n > (num_ale - 5)) {
                        System.out.println("O número está longe do correto.");
                    } else if (n == num_ale) {
                        System.out.println("Acertou em " + i + " tentativas.");
                    }
            }
            i++;
        } while (n != num_ale);
    }

    private static void NivelFacil(int op) {
        System.out.println("Nível Fácil");
        niveis(op);
    }

    private static void NivelMedio(int op) {
        System.out.println("Nível Médio");
        niveis(op);
    }

    private static void NivelDeus(int op) {
        System.out.println("Nível Deus");
        niveis(op);
    }
}