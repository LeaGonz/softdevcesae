import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    // Colores
    static final String reset = "\033[0m";
    static final String vermelho = "\033[0;31m";
    static final String verde = "\033[0;32m";
    static final String amarelo = "\033[0;33m";
    // Variaveis principais
    static ArrayList<String> ouvintes = new ArrayList<>();
    static ArrayList<Integer> jogosTotal = new ArrayList<>();
    static ArrayList<Integer> jogosGanhos = new ArrayList<>();
    // Variaveis só para ranking
    static ArrayList<String> ouvintest;
    static ArrayList<Integer> jogosTotalt, jogosGanhost;

    public static void main(String[] args) {
        int op;
        do {
            System.out.println(verde + "\nBEM-VINDO AO JOGO DO SACO" + reset);
            System.out.println("1- Menu Ouvintes");
            System.out.println("2- Jogar 'Jogo do Saco'");
            System.out.println("3- Ver Ranking de Ouvintes");
            System.out.println("4- Gravar em ficheiro 'Ranking de Ouvintes'");
            System.out.println("5- Ler ficheiro 'Ranking de Ouvintes'");
            System.out.println("0- Sair");
            op = validarOpcao();

            switch (op) {
                case 0:
                    System.out.println(vermelho + "Obrigado por participar! Até breve.");
                    break;
                case 1:
                    menuOvintes();
                    break;
                case 2:
                    jogoSaco();
                    break;
                case 3:
                    verRanking();
                    break;
                case 4:
                    gravarFicheiro();
                    break;
                case 5:
                    lerFicheiro();
                    break;
                default:
                    System.out.println(amarelo + "Opção invalida!" + reset);
            }
        } while (op != 0);
    }

    private static void limparDados() {
        ouvintes.clear();
        jogosTotal.clear();
        jogosGanhos.clear();
    } // validado

    private static void lerFicheiro() {
        System.out.println(verde + "\nLer Ficheiro do Raking do 'Jogo do Saco'" + reset);

        try {
            Path dirBD = Path.of("Ranking_BD.txt");
            List<String> linhas = Files.readAllLines(dirBD);
            if (!linhas.isEmpty()) {
                limparDados();
                for (String linha : linhas) {
                    String[] lines = linha.split(";");
                    ouvintes.add(lines[0]);
                    jogosTotal.add(Integer.valueOf(lines[1]));
                    jogosGanhos.add(Integer.valueOf(lines[2]));
                }
                System.out.println(verde + "Ficheiro lido com sucesso. Base de dados atualizada!" + reset);
            } else {
                System.out.println(amarelo + "Não existem dados no ficheiro." + reset);
            }
        } catch (IOException e) {
            System.out.println(vermelho + "Não existe o ficheiro: " + e.getMessage() + reset);
        }
    } // validado

    private static void gravarFicheiro() {
        // Chamamos função ordenar
        rankingOrder();

        System.out.println(verde + "\nGravar em Ficheiro o Raking do 'Jogo do Saco'" + reset);
        // Verificamos se existem ouvintes
        if (!ouvintest.isEmpty()) {
            // Path dos ficheiros: 1 do ranking, outro da base da dados dos ouvintes
            Path dir = Path.of("Ranking.txt");
            Path dirBD = Path.of("Ranking_BD.txt");

            try {
                // Preenchemos as linhas
                String linesBD = "";
                String lines = String.format("%-8s| %-22s| %-17s| %-8s%n", "Ranking", "Nomes", "Jogos Acertados", "Jogos");
                lines += "-".repeat(60) + "\n";
                for (int i = 0; i < ouvintest.size(); i++) {
                    lines += String.format("%-8d| %-22s| %-17s| %-8s%n", i + 1, ouvintest.get(i), jogosGanhost.get(i), jogosTotalt.get(i));
                    linesBD += ouvintest.get(i) + ";" + jogosTotalt.get(i) + ";" + jogosGanhost.get(i) + "\n";
                }
                // Escrevemos nos ficheiros
                Files.writeString(dir, lines);
                Files.writeString(dirBD, linesBD);
                System.out.println(verde + "Ficheiro criado com sucesso!" + reset);
            } catch (IOException e) {
                System.out.println(vermelho + e.getMessage() + reset);
            }

        } else {
            System.out.println(amarelo + "Não há informação para gravar no ficheiro." + reset);
        }
    } // validado

    private static void verRanking() {
        // Chamamos função ordenar
        rankingOrder();

        System.out.println(verde + "\nRaking do Jogo do Saco" + reset);
        // Listamos ouvintes se existem
        if (!ouvintest.isEmpty()) {
            System.out.printf(amarelo + "%-8s| %-22s| %-17s| %-8s%n" + reset, "Ranking", "Nomes", "Jogos Acertados", "Jogos");
            System.out.println("-".repeat(60));
            for (int i = 0; i < ouvintest.size(); i++) {
                System.out.printf("%-8d| %-22s| %-17s| %-8s%n", i + 1, ouvintest.get(i), jogosGanhost.get(i), jogosTotalt.get(i));
            }
        } else {
            System.out.println(amarelo + "Não existem ouvintes para mostrar o raking." + reset);
        }
    } // validado

    private static void rankingOrder() {
        // Preenchemos variaveis para ranking
        ouvintest = new ArrayList<>(ouvintes);
        jogosTotalt = new ArrayList<>(jogosTotal);
        jogosGanhost = new ArrayList<>(jogosGanhos);

        // Ordeno por jogos ganhos e em caso de empate por jogos totais
        for (int i = 0; i < jogosGanhost.size(); i++) {
            for (int j = i + 1; j < jogosGanhost.size(); j++) {
                if ((jogosGanhost.get(i) < jogosGanhost.get(j)) || (jogosGanhost.get(i).equals(jogosGanhost.get(j)) && jogosTotalt.get(i) > jogosTotalt.get(j))) {
                    // Ordenamos jogos ganhos
                    int tempG = jogosGanhost.get(i);
                    jogosGanhost.set(i, jogosGanhost.get(j));
                    jogosGanhost.set(j, tempG);

                    // Ordenamos jogos totales
                    int tempT = jogosTotalt.get(i);
                    jogosTotalt.set(i, jogosTotalt.get(j));
                    jogosTotalt.set(j, tempT);

                    // Ordenamos ouvintes
                    String tempO = ouvintest.get(i);
                    ouvintest.set(i, ouvintest.get(j));
                    ouvintest.set(j, tempO);
                }
            }
        }
    } // validado

    private static void jogoSaco() {
        System.out.println(verde + "\nJOGO DO SACO" + reset);
        // Validamos se há ouvintes
        if (!ouvintes.isEmpty()) {
            // Validamos se há pelo menos 2 ouvintes
            if (ouvintes.size() >= 2) {
                // Variaveis
                ArrayList<Integer> id = new ArrayList<>();
                ArrayList<Integer> jogaram = new ArrayList<>();
                int jogador, dif = Integer.MAX_VALUE;
                int pesoIni = rnd.nextInt(1000, 10001);
                int pesoCerto = rnd.nextInt(pesoIni, (pesoIni + 151));
                int nJogadores = rnd.nextInt(2, ouvintes.size() + 1);

                System.out.println("Regras: Adivinhar o peso do saco. Será dado o peso inicial mais uma margem de 150g.");
                System.out.println("Em cada jogo jogaram entre 2 a maximo " + ouvintes.size() + " ouvintes.\n");
                System.out.println(amarelo + "Adivinhe o peso do saco entre " + pesoIni + "g e " + (pesoIni + 150) + "g | " + nJogadores + " ouvintes." + reset);
                System.out.println("-".repeat(60));

                // Ciclo turnos dos jogadores
                for (int i = 0; i < nJogadores; i++) {
                    // Evitamos jogadores duplicados
                    do {
                        jogador = rnd.nextInt(ouvintes.size()); // indice do jogador aleatorio
                    } while (jogaram.contains(jogador));
                    jogaram.add(jogador);

                    // Peso jogador aleatorio
                    int pesoJogador;
                    if (ouvintes.get(jogador).equals("Anabela de Malhadas"))
                        pesoJogador = rnd.nextInt(pesoIni - 999, pesoIni - 500);
                    else pesoJogador = rnd.nextInt(pesoIni, (pesoIni + 151));

                    System.out.println("Jogador " + (i + 1) + ": " + ouvintes.get(jogador) + " diz que o peso correto é: " + verde + pesoJogador + "g." + reset);

                    // Preenchemos jogos totales
                    jogosTotal.set(jogador, jogosTotal.get(jogador) + 1);

                    // Acerto exato
                    if (pesoJogador == pesoCerto && dif == 0) {
                        id.add(jogador);

                    } else if (pesoJogador == pesoCerto) {
                        id.clear();
                        dif = 0;
                        id.add(jogador);

                        // Acerto mais próximo
                    } else if (Math.abs(pesoJogador - pesoCerto) < dif) {
                        dif = Math.abs(pesoJogador - pesoCerto);
                        id.clear();
                        id.add(jogador);
                        // Acerto mais próximo quando for mais de um jogador a dizer
                    } else if (Math.abs(pesoJogador - pesoCerto) == dif) {
                        id.add(jogador);
                    }

                } // fim ciclo
                System.out.println("-".repeat(60));
                System.out.println(verde + "O peso certo era: " + pesoCerto + reset);
                // Preenchemos acertos com arraylist id e mostramos
                for (Integer integer : id) {
                    jogosGanhos.set(integer, jogosGanhos.get(integer) + 1);
                    System.out.println(ouvintes.get(integer) + verde + " acertou!" + reset);
                }
            } else {
                System.out.println(amarelo + "Não há ouvintes suficientes para jogar! Por favor, insira pelo menos mais um ouvinte." + reset);
            }
        } else {
            System.out.println(amarelo + "Não existem ouvintes para jogar! Por favor, insira ouvintes." + reset);
        }

    } // validado

    private static void menuOvintes() {
        int op;
        do {
            System.out.println(verde + "\nMenu Ouvintes" + reset);
            System.out.println("1- Inserir Ouvinte");
            System.out.println("2- Lista de Ouvintes");
            System.out.println("3- Remover Ouvinte");
            System.out.println("0- Voltar ao menu principal");
            op = validarOpcao();

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
                    System.out.println(amarelo + "Opção invalida!" + reset);
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
        // Ciclo para inserir
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
                // Fechamos ciclo
                inserido = true;
            }
        }
    } // validado

    private static boolean listaOuvintes() {
        System.out.println(verde + "\nLista de Ouvintes" + reset);
        // Listamos ouvintes se existem
        if (!ouvintes.isEmpty()) {
            System.out.printf(amarelo + "%-2s| %-22s| %-8s| %-8s%n" + reset, "ID", "Nomes", "Jogos", "Jogos Acertados");
            System.out.println("-".repeat(55));
            for (int i = 0; i < ouvintes.size(); i++) {
                System.out.printf("%-2d| %-22s| %-8d| %-8d%n", i + 1, ouvintes.get(i), jogosTotal.get(i), jogosGanhos.get(i));
            }
            return true;
        } else {
            System.out.println(amarelo + "Não existem ouvintes para mostrar! Pode inserir na opção 1 do menu." + reset);
            return false;
        }
    } // validado

    private static int validarOpcao() {
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