import java.util.*;

public class Main {
    static final String reset = "\033[0m";
    static final String vermelho = "\033[0;31m";
    static final String verde = "\033[0;32m";
    static final String amarelo = "\033[0;33m";

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static ArrayList<Integer> chaveVencedora = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> chavesUtilizador = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> chavesAleatorias = new ArrayList<>();

    public static void main(String[] args) {
        /*
        O Euromilhões é um jogo de sorte ou azar no qual o jogador deve preencher uma chave composta por 5 números de 1 a
        50 e 2 estrelas (números) de 1 a 12. Crie uma aplicação que permita ao utilizador:
        1. Simular um sorteio (sortear uma chave vencedora que deve ser apresentada ao utilizador de forma ordenada).
        2. Criar um boletim com 1 a 5 chaves (inseridas pelo utilizador) e comparar com a chave vencedora desse sorteio.
        3. Criar um boletim com 1 a 5 chaves (criadas aleatoriamente) e comparar com a chave vencedora desse sorteio.
        4. Simular quantas vezes seria necessário jogar (sempre com a mesma chave) de forma a conseguir ganhar o 1º
        prémio (5 números e 2 estrelas).
        Informação extra: https://www.jogossantacasa.pt/web/SCCartazResult/
         */
        int op = 1;

        do {
            System.out.println("\nBEM-VINDO AO EUROMILHÕES");
            System.out.println("Menu do Jogo:");
            System.out.println("1- Simular um sorteio vencedor");
            System.out.println("2- Criar um Boletim pelo utilizador");
            System.out.println("3- Criar um Boletim aleatorio");
            System.out.println("4- Simulação de Apostas para Ganhar");
            System.out.println("0- Sair");
            op = in.nextInt();
            in = new Scanner(System.in);

            switch (op) {
                case 0:
                    break;
                case 1:
                    SimularVencedor();
                    break;
                case 2:
                    BoletimUtilizador();
                    GerarChaveVencedora();
                    CompararChaves(chavesUtilizador);
                    break;
                case 3:
                    CompararChaves(chavesAleatorias);
                    break;
                case 4:
                default:
                    System.out.println("Opção invalida!\n");
            }
        } while (op != 0);

    }

    private static void BoletimUtilizador() {
        chavesUtilizador.clear();
        // Listas temporais
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> estrelas = new ArrayList<>();
        ArrayList<Integer> utilizadorChave = new ArrayList<>();
        int chaves, n;
        boolean validar = true;

        System.out.println("\nMenu 2 - Criar um Boletim pelo utilizador");
        System.out.println("Regras: escolha 5 números e 2 estrelas por chave");
        // Validamos maximo de chaves
        do {
            System.out.println("Quantas chaves deseja jogar? (Máximo 5)");
            chaves = in.nextInt();
            if (chaves <= 5) {
                validar = false;
            } else {
                System.out.println("\nA quantidade de chaves não pode ser superior a 5!\n");
            }
        } while (validar);
        // Ciclo para criar quantidades de chaves
        for (int i = 0; i < chaves; i++) {
            System.out.println("<- Chave " + (i + 1) + " ->");
            // 5 numeros pelo utiliador
            while (numeros.size() < 5) {
                System.out.print("numero " + (numeros.size() + 1) + ": ");
                n = in.nextInt();
                // Validamos se o numero é valido ou não
                if (n < 1 || n > 50) {
                    System.out.println("Número fora do intervalo, deve ser entra 1-50!");
                } else if (numeros.contains(n)) {
                    System.out.println("O número já existe. Por favor, escolha outro.");
                } else {
                    numeros.add(n);
                }
            }
            // 2 estrelas pelo utilizador
            while (estrelas.size() < 2) {
                System.out.print("Estrela " + (estrelas.size() + 1) + ": ");
                n = in.nextInt();
                // Validamos se o numero é valido ou não
                if (n < 1 || n > 12) {
                    System.out.println("Número fora do intervalo, deve ser entra 1-12!");
                } else if (estrelas.contains(n)) {
                    System.out.println("A estrela já existe. Por favor, escolha outra.");
                } else {
                    estrelas.add(n);
                }
            }

            // Unimos listas
            utilizadorChave.addAll(numeros);
            utilizadorChave.addAll(estrelas);
            // Preenchemos lista principal
            chavesUtilizador.add(new ArrayList<>(utilizadorChave));

            MostrarChaves(chavesUtilizador.get(i));

            // Limpamos chaves temporais
            numeros.clear();
            estrelas.clear();
            utilizadorChave.clear();
        }
    }
    //-------------------------------------------------------

    private static void CompararChaves(ArrayList<ArrayList<Integer>> chaveComparar) {
        // Ciclo quantidades de chaves
        for (int i = 0; i < chaveComparar.size(); i++) {
            int acertosNum = 0;
            int acertosEstre = 0;

            for (int j = 0; j < 5; j++) {
                // Comparar números
                for (int k = 0; k < 5; k++) {
                    if (chaveComparar.get(i).get(j).equals(chaveVencedora.get(k))) {
                        acertosNum++;
                        break;
                    }
                }
            }
            // Comparar estrelas
            for (int j = 5; j < 7; j++) {
                for (int k = 5; k < 7; k++) {
                    if (chaveComparar.get(i).get(j).equals(chaveVencedora.get(k))) {
                        acertosEstre++;
                        break;
                    }
                }
            }
            System.out.println("\n--- Acertos Chave " + (i + 1) + " ---");
            System.out.print("Chave ->         \t\t");
            MostrarChaves(chaveComparar.get(i));
            System.out.print("Chave Vencedora -> \t\t");
            MostrarChaves(chaveVencedora);
            System.out.println("Números: " + acertosNum + " Estrelas: " + acertosEstre);
        } // Fim ciclo principal
    }

    private static void SimularVencedor() {
        System.out.println("\nMenu 1 - Simular um sorteio vencedor");
        System.out.print("Chave Vencedora: ");
        GerarChaveVencedora();
        MostrarChaves(chaveVencedora);
    }

    private static void GerarChaveVencedora() {
        chaveVencedora.clear();
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> estrelas = new ArrayList<>();
        int n;
        // Geramos 5 numeros entre 1 - 50
        while (numeros.size() < 5) {
            n = rnd.nextInt(1, 51);
            if (!numeros.contains(n)) {
                numeros.add(n);
            }
        }
        // Geramos 2 estrelas entre 1-12
        while (estrelas.size() < 2) {
            n = rnd.nextInt(1, 13);
            if (!estrelas.contains(n)) {
                estrelas.add(n);
            }
        }
        // Ordenamos
        Collections.sort(numeros);
        Collections.sort(estrelas);
        // Unimos chaves na chaveVencedora
        chaveVencedora.addAll(numeros);
        chaveVencedora.addAll(estrelas);
    }

    private static void MostrarChaves(ArrayList<Integer> chave) {
        for (int i = 0; i < chave.size(); i++) {
            if (i < 5) {
                System.out.printf(verde + "|%d|", chave.get(i));
            } else {
                System.out.printf(amarelo + "<%d>" + reset, chave.get(i));
            }
        }
        System.out.println();
    }
}