import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    // Cores
    static final String reset = "\033[0m";
    static final String vermelho = "\033[0;31m";
    static final String verde = "\033[0;32m";
    static final String amarelo = "\033[0;33m";
    // Variáveis principais
    static ArrayList<String> ouvintes = new ArrayList<>();
    static ArrayList<Integer> jogosTotal = new ArrayList<>();
    static ArrayList<Integer> jogosGanhos = new ArrayList<>();
    // Variáveis só para ranking
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
        // Limpamos os arrayList principais
        ouvintes.clear();
        jogosTotal.clear();
        jogosGanhos.clear();
    }

    private static void lerFicheiro() {
        /* Metodo para ler ficheiro com dados "Ranking_BD.txt", com 3 ouvintes predefinidos */
        System.out.println(verde + "\nLer Ficheiro do Raking do 'Jogo do Saco'" + reset);

        try {
            Path dirBD = Path.of("Ranking_BD.txt");
            List<String> linhas = Files.readAllLines(dirBD);
            if (!linhas.isEmpty()) {
                // Limpamos os arrayLists antes de adicionar nova informação
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
    }

    private static void gravarFicheiro() {
        /* Metodo para criar ficheiros com dados dos ouvintes e ranking dos jogos. São criados 2
        ficheiros por separado "Ranking.txt" e "Ranking_BD.txt" */
        // Chamamos função ordenar
        rankingOrder();

        System.out.println(verde + "\nGravar em Ficheiro o Raking do 'Jogo do Saco'" + reset);
        // Verificamos se existem ouvintes
        if (!ouvintest.isEmpty()) {
            /* Path dos ficheiros: 1 do ranking, 2 da base de dados dos ouvintes, assim poderemos usar a
            informação num futuro */
            Path dir = Path.of("Ranking.txt");
            Path dirBD = Path.of("Ranking_BD.txt");

            try {
                // Preenchemos as linhas
                String linesBD = "";
                String lines = String.format("%-8s| %-22s| %-17s| %-8s%n", "Ranking", "Nomes", "Jogos Acertados",
                        "Jogos");
                lines += "-".repeat(60) + "\n";
                for (int i = 0; i < ouvintest.size(); i++) {
                    lines += String.format("%-8d| %-22s| %-17s| %-8s%n", i + 1, ouvintest.get(i), jogosGanhost.get(i),
                            jogosTotalt.get(i));
                    // Preenchemos com o formato predefinido separados por uma ";"
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
    }

    private static void verRanking() {
        /* Metodo para mostrar o ranking dos jogos em ordem decrescente */
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
    }

    private static void rankingOrder() {
        /* Metodo para ordenador os ouvintes por ganhos e criar um ranking decrescente */
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
    }

    private static void jogoSaco() {
        /* Metodo principal do jogo. Neste metodo definimos de maneira automática o peso rango do peso,
        o peso certo, o número de jogadores e os jogos dos jogadores */
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
                    // Evitamos jogadores duplicados se o jogador já existe no arrayList "jogaram"
                    do {
                        jogador = rnd.nextInt(ouvintes.size()); // indice do jogador aleatorio
                    } while (jogaram.contains(jogador));
                    jogaram.add(jogador);

                    // Criamos o peso jogador aleatório
                    int pesoJogador;
                    // Se o ouvinte é Luis ou Bruno, os jogadores poderão inserir o peso manualmente
                    if (ouvintes.get(jogador).equalsIgnoreCase("Luis") ||
                            ouvintes.get(jogador).equalsIgnoreCase("Bruno")) {
                        while (true) {
                            try {
                                System.out.print(vermelho + ouvintes.get(jogador) + reset + " insire o peso: ");
                                pesoJogador = in.nextInt();
                                in = new Scanner(System.in);
                                if (pesoJogador >= pesoIni && pesoJogador <= (pesoIni + 150)) {
                                    break;
                                } else {
                                    System.out.println(amarelo + "Peso fora do intervalo! Por favor, insira um valor válido." + reset);
                                }
                            } catch (NumberFormatException e) {
                                System.out.println(vermelho + "Entrada inválida! Por favor, insira um número válido." + reset);
                            }
                        }
                    }
                    // Se o ouvinte é Anabela, o peso sempre será invalido, coitadinha da Anabela =(
                    else if (ouvintes.get(jogador).equals("Anabela de Malhadas")) {
                        pesoJogador = rnd.nextInt(pesoIni - 999, pesoIni - 500);
                        // Aqui joga um ouvinte aleatório e automático
                    } else {
                        pesoJogador = rnd.nextInt(pesoIni, (pesoIni + 151));
                    }

                    System.out.println("Jogador " + (i + 1) + ": " + ouvintes.get(jogador) + " diz que o peso correto é: " + verde + pesoJogador + "g." + reset);

                    // Preenchemos jogos totais
                    jogosTotal.set(jogador, jogosTotal.get(jogador) + 1);

                    // Acrescentamos se o acerto é exato
                    if (pesoJogador == pesoCerto && dif == 0) {
                        id.add(jogador);

                    } else if (pesoJogador == pesoCerto) {
                        id.clear();
                        dif = 0;
                        id.add(jogador);

                        // Acrescentamos se o acerto é mais próximo ao peso certo
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

    }

    private static void menuOvintes() {
        /* Menu principal para ouvintes */
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
    }

    private static void removerOuvintes() {
        /* Metodo para remover ouvintes */

        while (true) {
            try {
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
                        break;
                    } else {
                        System.out.println(amarelo + "Não existe ouvinte com o ID indicado." + reset);
                    }
                } else break;
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Deve inserir um número!\n" + reset);
                in = new Scanner(System.in);
            }
        }
    }

    private static void inserirOuvinte() {
        /* Metodo para inserir ouvintes novos */
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
    }

    private static boolean listaOuvintes() {
        /* Metodo para mostrar os ouvintes e os IDs, assim poderemos saber que ouvinte remover */
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
    }

    private static int validarOpcao() {
        int op = 0;
        while (true) {
            try {
                System.out.print("Opção: ");
                op = in.nextInt();
                in = new Scanner(System.in);
                break;
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Opção invalida! Por favor, deve inserir um número do menu!\n" + reset);
                in = new Scanner(System.in);
            }
        }
        return op;
    }
}