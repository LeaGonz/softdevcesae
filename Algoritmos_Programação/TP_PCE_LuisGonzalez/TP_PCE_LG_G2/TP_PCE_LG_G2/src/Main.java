import java.util.*;

public class Main {
    static final String reset = "\033[0m";
    static final String vermelho = "\033[0;31m";
    static final String verde = "\033[0;32m";
    static final String amarelo = "\033[0;33m";

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    static ArrayList<String> ouvintes = new ArrayList<>();
    static ArrayList<Integer> jogosTotal = new ArrayList<>();
    static ArrayList<Integer> jogosGanhos = new ArrayList<>();

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

        int op;
        do {
            System.out.println(verde + "\nBEM-VINDO AO JOGO DO SACO" + reset);
            System.out.println("1- Menu Ouvintes");
            System.out.println("2- Jogar 'Jogo do Saco'");
            System.out.println("3- Ver Ranking de Ouvintes");
            System.out.println("4- Gravar em ficheiro 'Ranking de Ouvintes'");
            System.out.println("5- Ler ficheiro 'Ranking de Ouvintes'");
            System.out.println("0- Sair");
            op = validarOp();

            switch (op) {
                case 0:
                    System.out.println(verde + "Obrigado por participar! Até breve.");
                    break;
                case 1:
                    menuOvintes();
                    break;
                case 2:
                    jogoSaco();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println(amarelo + "Opção invalida!" + reset);
            }
        } while (op != 0);
    }

    private static void jogoSaco() {
        System.out.println(verde + "\nJOGO DO SACO" + reset);
        System.out.println("Regra: adivinhar o peso do saco. Será dado o peso inicial mais uma margem de 150g.\nEm cada ronda jogaram entra 2 a 4 jogadores.\n");
        if (!ouvintes.isEmpty()) {
            int pesoini = rnd.nextInt(4000, 5001);
            int pesoCerto = rnd.nextInt(pesoini, (pesoini + 150));
            System.out.println("Adivinhe o peso do saco entre " + pesoini + "g e " + (pesoini + 150) + "g.");
            int jogador = rnd.nextInt(ouvintes.size());
            int pesoJogador = rnd.nextInt(pesoini, (pesoini + 150));
            System.out.println("Jogador: " + ouvintes.get(jogador) + " peso: " + pesoJogador + "g.");
        } else {
            System.out.println(amarelo + "Não existem ouvintes para jogar! Por favor, insira ouvintes." + reset);
        }


    }

    private static void menuOvintes() {
        int op;
        do {
            System.out.println(verde + "\nMenu Ouvintes" + reset);
            System.out.println("1- Inserir Ouvinte");
            System.out.println("2- Lista de Ouvintes");
            System.out.println("3- Remover Ouvinte");
            System.out.println("0- Voltar ao menu principal");
            op = validarOp();

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
    } // validado

    private static void removerOuvintes() {
        // Validamos se existem ouvintes
        if (listaOuvintes()) {
            System.out.println(verde + "\nRemover Ouvintes" + reset);
            System.out.print("ID do ouvinte a remover: ");
            int id = in.nextInt();
            in = new Scanner(System.in);
            // Validamos se ID é valido e se existe ouvinte
            if (id > 0 && id <= ouvintes.size()) {
                System.out.println(ouvintes.get(id - 1) + " com ID " + id + " removido com sucesso.");
                ouvintes.remove(id - 1);
                jogosTotal.remove(id - 1);
                jogosGanhos.remove(id - 1);
            } else {
                System.out.println(amarelo + "Não existe ouvinte com o ID indicado." + reset);
            }
        }
    } // validado

    private static void inserirOuvinte() {
        boolean inserido = false;
        while (!inserido) {
            System.out.println(verde + "\nInserir Ouvinte" + reset);
            System.out.print("Nome: ");
            String nome = in.nextLine();
            if (ouvintes.contains(nome)) {
                System.out.println(amarelo + "O nome já existe. Por favor inserir outro." + reset);
            } else if (nome.isBlank()) {
                System.out.println(amarelo + "O nome não pode estar em branco! Por favor, escrever um nome." + reset);
            } else {
                ouvintes.add(nome);
                jogosTotal.add(0);
                jogosGanhos.add(0);
                System.out.println("Ouvinte " + verde + nome + reset + " inserido com sucesso!");
                inserido = true;
            }
        }
    } // validado

    private static boolean listaOuvintes() {
        System.out.println(verde + "\nLista de Ouvintes" + reset);
        // Listamos ouvintes se existem
        if (!ouvintes.isEmpty()) {
            System.out.printf(amarelo + "%-2s| %-22s| %-8s| %-8s%n" + reset, "ID", "Nomes", "Jogos", "Jogos Acertados");
            System.out.println("-".repeat(50));
            for (int i = 0; i < ouvintes.size(); i++) {
                System.out.printf("%-2d| %-22s| %-8d| %-8d%n", i + 1, ouvintes.get(i), jogosTotal.get(i), jogosGanhos.get(i));
            }
            return true;
        } else {
            System.out.println(amarelo + "Não existem ouvintes para mostrar! Pode inserir na opção 1 do menu." + reset);
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
    } // validado
}