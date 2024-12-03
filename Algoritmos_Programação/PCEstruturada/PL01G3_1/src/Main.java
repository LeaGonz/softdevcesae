import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] tabuada;
    static Scanner in = new Scanner(System.in);
    static int li, col;

    public static void main(String[] args) {
        /*
        1. Crie uma aplicação que peça ao utilizador um conjunto de números inteiros e os
        guarde num array.
         */
        System.out.println("Insira o número de linhas:");
        li = in.nextInt();
        System.out.println("Insira o número de colunas:");
        col = in.nextInt();
        tabuada = new int[li][col];

        System.out.println("Insira os valores da tabuada");
        for (int i = 0; i < li; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Valor (" + i + "," + j + "): ");
                tabuada[i][j] = in.nextInt();
            }
        }

        int op = 1;
        do {
            System.out.println("Exercícios Grupo III");
            System.out.println("1- Ordenar Crescente");
            System.out.println("2- Ordenar Decrescente");
            System.out.println("3- Imprimir Tabuada");
            System.out.println("4- Adicionar no fim da tabuada");
            System.out.println("5- Adicionar numa posição específica, alterando valor");
            System.out.println("6- Adicionar numa posição específica, adicionando valor");
            System.out.println("7- Eliminar um valor da tabuada");
            System.out.println("0- Sair");
            op = in.nextInt();
            in = new Scanner(System.in);

            switch (op) {
                case 0:
                    break;
                case 1:
                case 2:
                case 3:
                    Imprimir();
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    System.out.println("Opção invalida.");
            }

        } while (op != 0);
    }

    private static void Imprimir() {
        System.out.println("--- Tabuada ---");
        for (int i = 0; i < li; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(tabuada[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }
}