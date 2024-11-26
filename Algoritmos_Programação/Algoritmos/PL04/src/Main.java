import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    public static void main(String[] args) {
        int op;
        do {
            System.out.println("Jogos de Sorte");
            System.out.println("1- Lotaria");
            System.out.println("2- Raspadinhas");
            System.out.println("0- Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    Lotaria();
                    break;
                case 2:
                    Raspadinhas();
                    break;
                default:
                    System.out.println("** Opção invalida **");
            }
        } while (op != 0);

    }

    private static void Lotaria() {
        // Escolhemos bilhete
        int bilhete = 0;
        do {
            System.out.println("**** LOTARIA ****");
            System.out.println("Escolha o seu número de bilhete: (entre 1000 e 9999)");
            bilhete = in.nextInt();
            if (bilhete < 1000 || bilhete > 9999) System.out.println("Número de bilhete errado.");
        } while (bilhete < 1000 || bilhete > 9999);

        // Bilhete random
        int bilhete_ganho = rnd.nextInt(1000, 10000);

        // Premios
        if (bilhete == bilhete_ganho) {
            System.out.println("Número vencedor! Ganhou 100€");
        } else if ((bilhete % 1000) == (bilhete_ganho % 1000)) {
            System.out.println("Ganhaste o 2º prémio: 50€");
        } else if ((bilhete % 100) == (bilhete_ganho % 100)) {
            System.out.println("Ganhaste o 3º prémio: 20€");
        } else {
            System.out.println("Não foi desta vez. O número vencedor foi: " + bilhete_ganho);
        }
    }

    private static void Raspadinhas() {
        int op;
        do {
            System.out.println("**** RASPADINHAS ****");
            System.out.println("1- Jogo 1");
            System.out.println("2- Jogo 2");
            System.out.println("0- Voltar ao menu inicial");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    Raspadinha1();
                    break;
                case 2:
                    Raspadinha2();
                    break;
                default:
                    System.out.println("** Opção invalida **");
            }
        } while (op != 0);
    }

    private static void Raspadinha1() {
        // Numero principal
        System.out.println("Número para o jogo:");
        //int np = rnd.nextInt(1, 11);
        int np = in.nextInt();
        int saldo = 0;
        // 5 ciclos random
        for (int i = 1; i < 6; i++) {
            int nr = rnd.nextInt(1, 11);
            System.out.println(np + " = " + nr);
        // Verificação de premios
            if (np == nr) {
                switch (i) {
                    case 1: saldo += 100; break;
                    case 2: saldo += 1; break;
                    case 3: saldo += 1; break;
                    case 4: saldo += 10; break;
                    case 5: saldo += 10; break;
                }
            }
        }
        if (saldo != 0){
            System.out.println("Ganhou: " + saldo + "€");
        } else {
            System.out.println("Não foi desta vez, tenta novamente.");
        }
    }

    private static void Raspadinha2() {
        // Numero principal
        int np = rnd.nextInt(1, 11);
        System.out.println("O seu número de jogo é: " + np);
        int saldo = 0;
        int count = 0;
        // 9 ciclos random
        System.out.print("Os 9 números sorteados são: ");
        for (int i = 0; i < 9; i++) {
            int nr = rnd.nextInt(1, 11);
            System.out.print(nr + "\t");
            if (np == nr) {
                count++;
            }
        }
        System.out.println();
        if (count >= 3) {
            int ganho = rnd.nextInt(1, 11);
            System.out.println("Ganhaste: " + ganho + "€");
        } else {
            System.out.println("Não foi desta vez, tenta novamente.");
        }
    }


}