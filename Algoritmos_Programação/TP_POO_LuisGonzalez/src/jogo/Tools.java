package jogo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {
    private static final Scanner in = new Scanner(System.in);

    /**
     * Método para validar se é interger ou não
     *
     * @return
     */
    public static int validarEscolhaNum() {
        while (true) {
            try {
                int escolha = in.nextInt();
                in.nextLine();
                return escolha;
            } catch (InputMismatchException e) {
                System.out.println("Opção invalida! Por favor, escolha uma personagem!\n");
                in.nextLine();
            }
        }
    }

    /**
     * Método para validar uma respostas S/N
     *
     * @return
     */
    public static boolean validarSimNao() {
        while (true) {
            try {
                String escolha = in.nextLine().trim().toUpperCase();
                if (escolha.equals("S")) {
                    return true;
                } else if (escolha.equals("N")) {
                    return false;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Hmm... S ou N, jovem. Não é tão difícil assim!");
            }
        }
    }

    /**
     * Método para pausar a execução
     */
    public static void pausar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPressione  ENTER para continuar...");
        scanner.nextLine();
    }
}

