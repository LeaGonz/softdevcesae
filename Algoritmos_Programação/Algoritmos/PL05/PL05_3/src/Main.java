
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         * 2 utilizadores, retirar 1 a 4 fosforos, 21 fosforos, quem ficar com ultimo
         * fosforo perde, jogar 1 vs 1, 1 vs computador, comeÃ§ando en 1 o 2 lugar
         */
        int op = 1;
        do {
            System.out.println("** Jogo dos 21 FÃ³sforos **");
            System.out.println("Selecione a modalidade do jogo:");
            System.out.println("1- 1 vs 1");
            System.out.println("2- 1 vs Computador");
            System.out.println("0- Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1, 2:
                    Jogo(op);
                    break;
                default:
                    System.out.println("OpÃ§Ã£o invalida!");
            }
        } while (op != 0);
    }

    private static void Jogo(int op) {
        int total_fos = 21, retiro, turno = rnd.nextInt(1, 3);
        String jogador;
        //System.out.println(turno);
        // Loop principal
        System.out.println("** Jogo: 1 vs 1 **");
        do {
            if (turno == 1) {
                jogador = "Jogador 1";
                turno++;
            } else {
                turno--;
                if (op == 1) {
                    jogador = "Jogador 2";
                } else {
                    jogador = "Computador";
                }
            }
            System.out.println("Turno: " + jogador);
            // Loop retirar fosforos
            do {
                System.out.println("Quantos fósforos quer retirar? (Max 4)\tTotal Fósforos: " + total_fos);
                if ("Computador".equals(jogador)) {
                    retiro = rnd.nextInt(1, 5);
                    System.out.println(retiro);
                } else {
                    retiro = in.nextInt();
                }

                if (retiro >= 1 && retiro <= 4) {
                    total_fos -= retiro;
                } else {
                    System.out.println("Quantidade invalida!");
                }
                if (total_fos == 1) {
                    System.out.println("O ganador é o: " + jogador + "\n");
                    break;
                }
            } while (retiro < 1 || retiro > 4);
            //break;
        } while (total_fos != 1);
    }
}
