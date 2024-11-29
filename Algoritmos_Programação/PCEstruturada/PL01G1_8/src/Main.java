import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);
    static String[] nomes = new String[4];
    static String[] letras = new String[4];
    static boolean empty = true;

    public static void main(String[] args) {
        /*
        7. Faça um programa que peça ao utilizador um conjunto de nomes. Sempre que o utilizador
         insere um nome deve inserir num outro vetor a 1ª letra de cada nome.
         Permita ao utilizador escrever o conteúdo de cada vetor.
         Sugere-se a utilização de um menu.
         8. Altere o exercício anterior ordenando os vetores.
         */
        int op = 1;
        do {
            System.out.println("1- Inserir nomes");
            System.out.println("2- Mostrar listado de nomes");
            System.out.println("3- Mostrar listado de letras");
            System.out.println("4- Ordenado alfabeticamente");
            System.out.println("0- Sair");
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 0:
                    break;
                case 1:
                    InserirNomes();
                    break;
                case 2:
                    MostrarArray(nomes, "Nomes");
                    break;
                case 3:
                    MostrarArray(letras, "Letras");
                    break;
                case 4:
                    OrdenAlfa();
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        } while (op != 0);
    }

    private static void OrdenAlfa() {
        String temp;
        if (empty) {
            System.out.println("A lista esta vazia, por favor carregue na opção 1");
        } else {
            for (int i = 0; i < nomes.length; i++) {
                for (int j = 0; j < nomes.length - 1; j++) {
                    if (nomes[j].compareTo(nomes[j + 1]) > 0) {
                        temp = nomes[j];
                        nomes[j] = nomes[j + 1];
                        nomes[j + 1] = temp;
                    }
                }
            }
            MostrarArray(nomes, "Nomes");
        }
    }

    private static void InserirNomes() {
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Inserir o nome " + (i + 1) + ": ");
            nomes[i] = in.nextLine();
            for (String letra : nomes[i].split("")) {
                letras[i] = letra;
                break;
            }
        }
        empty = false;
    }

    private static void MostrarArray(String[] array, String str) {
        if (empty) {
            System.out.println("A lista esta vazia, por favor carregue na opção 1");
        } else {
            System.out.println("Lista de " + str + ": ");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "\t");
                if ((i + 1) % 2 == 0) {
                    System.out.println();
                }
            }
        }
    }
}