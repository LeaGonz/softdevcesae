package jogo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {
    private static Scanner in = new Scanner(System.in);

    public static int validarEscolha() {
        int escolha = 0;
        while (true) {
            try {
                System.out.print("Escolha: ");
                escolha = in.nextInt();
                in = new Scanner(System.in);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Opção invalida! Por favor, escolha uma personagem!\n");
                in = new Scanner(System.in);
            }
        }
        return escolha;
    }
}

