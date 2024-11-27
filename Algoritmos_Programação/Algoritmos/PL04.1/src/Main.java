import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        int op;
        int saldo = 100;
        String utili = "Guest";
        do {
            System.out.println("Jogos de Sorte \t Utilizador: "+ utili +" Saldo: " + saldo + "€");
            System.out.println("1- Lotaria");
            System.out.println("2- Raspadinhas");
            System.out.println("3- Criar utilizador");
            System.out.println("0- Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    saldo = Lotaria(saldo);
                    break;
                case 2:
                    saldo = Raspadinhas(saldo);
                    break;
                case 3:
                    System.out.println("Insira nome do utilizador:");
                    utili = in.next();
                    break;
                default:
                    System.out.println("** Opção invalida **");
            }
        } while (op != 0);

    }
    private static int Lotaria(int saldo) {
        saldo -= 5;
        // Escolhemos bilhete
        int bilhete = 0;
        do {
            System.out.println("**** LOTARIA **** \t\b Saldo: " + saldo + "€");
            System.out.println("Escolha o seu número de bilhete: (entre 1000 e 9999)");
            bilhete = in.nextInt();
            if (bilhete < 1000 || bilhete > 9999) System.out.println("Número de bilhete errado.\n");
        } while (bilhete < 1000 || bilhete > 9999);

        // Bilhete random
        int bilhete_ganho = rnd.nextInt(1000, 10000);

        // Premios
        int ganho = 0;
        if (bilhete == bilhete_ganho) {
            System.out.println("Número vencedor! Ganhou 100€\n");
            ganho = 100;
        } else if ((bilhete % 1000) == (bilhete_ganho % 1000)) {
            System.out.println("Ganhaste o 2º prémio: 50€\n");
            ganho = 50;
        } else if ((bilhete % 100) == (bilhete_ganho % 100)) {
            System.out.println("Ganhaste o 3º prémio: 20€\n");
            ganho = 20;
        } else {
            System.out.println("Não foi desta vez. O número vencedor foi: " + bilhete_ganho + "\n");
        }
        return (saldo + ganho);
    }

    private static int Raspadinhas(int saldo) {
        int op;
        do {
            System.out.println("**** RASPADINHAS **** \t\b Saldo: " + saldo + "€");
            System.out.println("1- Jogo 1");
            System.out.println("2- Jogo 2");
            System.out.println("0- Voltar ao menu inicial");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    saldo = Raspadinha1(saldo);
                    break;
                case 2:
                    saldo = Raspadinha2(saldo);
                    break;
                default:
                    System.out.println("** Opção invalida **");
            }
        } while (op != 0);
        return saldo;
    }

    private static int Raspadinha1(int saldo) {
        saldo -= 2;
        System.out.println("Raspadinha 1 \t\b Saldo: " + saldo + "€");
        // Numero principal
        System.out.println("Número para o jogo:");
        //int np = rnd.nextInt(1, 11);
        int np = in.nextInt();
        int ganhado = 0;
        // 5 ciclos random
        for (int i = 1; i < 6; i++) {
            int nr = rnd.nextInt(1, 11);
            // Verificação de premios
            if (np == nr) {
                switch (i) {
                    case 1:
                        ganhado += 100;
                        break;
                    case 2:
                        ganhado += 1;
                        break;
                    case 3:
                        ganhado += 1;
                        break;
                    case 4:
                        ganhado += 10;
                        break;
                    case 5:
                        ganhado += 10;
                        break;
                }
            }
        }
        if (ganhado != 0) {
            System.out.println("Ganhou: " + ganhado + "€\n");
        } else {
            System.out.println("Não foi desta vez, tenta novamente.\n");
        }
        return (saldo + ganhado);
    }

    private static int Raspadinha2(int saldo) {
        saldo -= 2;
        System.out.println("Raspadinha 2 \t\b Saldo: " + saldo + "€");
        // Numero principal
        int np = rnd.nextInt(1, 11);
        System.out.println("O seu número de jogo é: " + np);
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
            System.out.println("Ganhaste: " + ganho + "€\n");
            saldo += ganho;
        } else {
            System.out.println("Não foi desta vez, tenta novamente.\n");
        }
        return saldo;
    }


}