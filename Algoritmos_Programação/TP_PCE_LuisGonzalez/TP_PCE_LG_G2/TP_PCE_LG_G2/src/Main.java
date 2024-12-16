import java.util.*;

public class Main {
    static final String reset = "\033[0m";
    static final String vermelho = "\033[0;31m";
    static final String verde = "\033[0;32m";
    static final String amarelo = "\033[0;33m";

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    static ArrayList<String> ouvintes = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> jogosGanhos = new ArrayList<>();
    static ArrayList<Integer> jogosTotal = new ArrayList<>();

    public static void main(String[] args) {
        /*
A “Anabela de Malhadas” margem de 150g (ex.: entre4,200kg e 4,350kg)
Faça uma aplicação que permita aos ouvintes jogar no “Jogo do Saco”. Implemente as seguintes opções:
1. Adicionar e remover ouvintes.
2. Ver ranking de ouvintes (número de vezes que jogaram e número de vezes que acertaram).
3. Jogar.
4. Ler e gravar ranking em ficheiro.
Em cada jogo devem ser selecionados de forma aleatória quais os ouvintes que vão jogar e a sua ordem. Em cada jogo o
vencedor será o que se aproximar mais do valor do peso do saco.
         */

        int op = 1;
        do {
            System.out.println(verde + "\nBEM-VINDO AO JOGO DO SACO" + reset);
            System.out.println("1- Menu Ouvintes");
            System.out.println("2- Jogar 'Jogo do Saco'");
            System.out.println("3- Ver Ranking de Ouvintes");
            System.out.println("4- Gravar em ficheiro 'Ranking de Ouvintes'");
            System.out.println("5- Ler ficheiro 'Ranking de Ouvintes'");
            System.out.println("0- Sair");
            op = validarOp();
            /*try {
                System.out.print("Opção: ");
                op = in.nextInt();
                in = new Scanner(System.in);
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Opção invalida! Por favor, deve inserir um número do menu!\n" + reset);
                in = new Scanner(System.in);
                continue;
            }*/

            switch (op) {
                case 0:
                    System.out.println(verde + "Obrigado por participar! Até breve.");
                    break;
                case 1:
                    MenuOvintes();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println(amarelo + "Opção invalida!\n" + reset);
            }
        } while (op != 0);
    }

    private static void MenuOvintes() {
        int op;
        do {
            System.out.println(verde + "\nMenu Ouvintes" + reset);
            System.out.println("1- Inserir Ouvinte");
            System.out.println("2- Lista de Ouvintes");
            System.out.println("3- Remover Ouvinte");
            System.out.println("0- Voltar ao menu principal");
            op = validarOp();
            /*try {
                System.out.print("Opção: ");
                op = in.nextInt();
                in = new Scanner(System.in);
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Opção invalida! Por favor, deve inserir um número do menu!\n" + reset);
                in = new Scanner(System.in);
                continue;
            }*/

            switch (op) {
                case 0:
                    break;
                case 1:
                    inserirOuvinte();
                    break;
                case 2:
                    listaOuvintes();
                    break;
                case 3:
                    removerOuvintes();
                    break;
                default:
                    System.out.println(amarelo + "Opção invalida!\n" + reset);
            }
        } while (op != 0);
    }

    private static void removerOuvintes() {
        System.out.println(verde + "\nRemover Ouvintes" + reset);
        if (listaOuvintes()) {
            System.out.print("ID do ouvinte a remover: ");
            int id = in.nextInt();
            in = new Scanner(System.in);
            if (id > 0 && id <= ouvintes.size()) {
                System.out.println(ouvintes.get(id - 1) + " removido com sucesso!");
            } else {
                System.out.println(id + " Nao existe");
            }
        }
    }

    private static void inserirOuvinte() {
        ArrayList<Integer> ganhos = new ArrayList<>();
        boolean inserido = false;
        while (!inserido) {
            System.out.println(verde + "\nInserir Ouvinte" + reset);
            System.out.print("Nome: ");
            String nome = in.nextLine();
            if (ouvintes.contains(nome)) {
                System.out.println(amarelo + "O nome já existe. Por favor inserir outro." + reset);
            } else if (nome.isBlank()) {
                System.out.println(amarelo + "O nome não pode estar em branco! Por favor, inserir um nome." + reset);
            } else {
                ouvintes.add(nome);
                jogosTotal.add(0);
                ganhos.add(0);
                ganhos.add(ouvintes.indexOf(nome));
                jogosGanhos.add(ganhos);
                System.out.println("Ouvinte " + verde + nome + reset + " inserido com sucesso!\n");
                inserido = true;
            }
        }
    } // validado

    private static boolean listaOuvintes() {
        if (!ouvintes.isEmpty()) {
            System.out.println(verde + "\nLista de Ouvintes" + reset);
            System.out.printf(amarelo + "%-2s| %-22s| %-8s| %-8s%n" + reset, "ID", "Nomes", "Jogos", "Jogos Acertados");
            System.out.println("-".repeat(50));
            for (int i = 0; i < ouvintes.size(); i++) {
                System.out.printf("%-2d| %-22s| %-8d| %-8d%n", i + 1, ouvintes.get(i), jogosTotal.get(i), jogosGanhos.get(i).getFirst());
            }
            return true;
        } else {
            System.out.println(amarelo + "Não existem ouvintes para mostrar! Pode inserir na opção 1 do menu.\n" + reset);
            return false;
        }
    } // validado

    private static int validarOp() {
        boolean validar = true;
        int op = 0;
        do {
            try {
                System.out.print("Opção: ");
                op = in.nextInt();
                in = new Scanner(System.in);
                validar = false;
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Opção invalida! Por favor, deve inserir um número do menu!\n" + reset);
                in = new Scanner(System.in);
            }
        } while (validar);
        return op;
    }
}