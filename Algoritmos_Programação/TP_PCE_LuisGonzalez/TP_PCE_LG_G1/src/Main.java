import java.util.*;

public class Main {
    static final String reset = "\033[0m";
    static final String vermelho = "\033[0;31m";
    static final String verde = "\033[0;32m";
    static final String amarelo = "\033[0;33m";

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static ArrayList<Integer> chaveVencedora = new ArrayList<>();

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
            System.out.println(verde + "\nBEM-VINDO AO EUROMILHÕES" + reset);
            System.out.println("Menu do Jogo:");
            System.out.println("1- Simular um sorteio vencedor");
            System.out.println("2- Criar um Boletim Utilizador");
            System.out.println("3- Criar um Boletim Aleatorio");
            System.out.println("4- Simulação quantidade de vezes para Ganhar");
            System.out.println("0- Sair");
            try {
                op = in.nextInt();
                in = new Scanner(System.in);
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Opção invalida! Por favor, deve inserir um número do menu!\n" + reset);
                in = new Scanner(System.in);
                continue;
            }

            switch (op) {
                case 0:
                    System.out.println(verde + "Obrigado por participar! Até breve.");
                    break;
                case 1:
                    SimularVencedor();
                    break;
                case 2:
                    BoletimUtilizador();
                    break;
                case 3:
                    BoletimAleatorio();
                    break;
                case 4:
                    SimularGanhar();
                    break;
                default:
                    System.out.println(amarelo + "Opção invalida!\n" + reset);
            }
        } while (op != 0);

    }

    private static void SimularGanhar() {
        ArrayList<Integer> chaveUnica = new ArrayList<>();
        int count = 0;
        System.out.println("\nMenu 4 - Simulação quantidade de vezes para Ganhar");
        System.out.println("Regras: escolha 5 números e 2 estrelas por chave");
        System.out.println("<- Chave Unica ->");
        // Gerar chaves utilizador
        chaveUnica = GerarChaveUti();
        // Mostramos chave
        MostrarChaves(chaveUnica);
        // Sort para logo comparar
        Collections.sort(chaveUnica);
        // Contagem de tempo
        long inicio = System.currentTimeMillis();
        // Simulação
        do {
            count++;
            // limpamos chave antes de gerar novos valores
            chaveVencedora.clear();
            chaveVencedora = GerarChaveAle();
            Collections.sort(chaveVencedora);
            if (count % 1_000_000 == 0) {
                System.out.println("Tentativas realizadas: " + vermelho + count + reset);
            }
        } while (!chaveVencedora.equals(chaveUnica));
        // Contagem de tempo
        long fin = System.currentTimeMillis();
        long duracion = (fin - inicio) / 1000;
        System.out.println("Número de sorteios necessários para ganhar o " + verde + "1º prémio: " + reset + count);
        System.out.println("Tempo total da simulação: " + duracion + " segundos.");
    }

    private static ArrayList<Integer> GerarChaveUti() {
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> estrelas = new ArrayList<>();
        ArrayList<Integer> chaveUti = new ArrayList<>();
        int n;

        // 5 numeros pelo utiliador
        System.out.println("Regras: Inserir um número entre 1 e 50.");
        while (numeros.size() < 5) {
            try {
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
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Por favor, deve inserir um número!" + reset);
                in = new Scanner(System.in);
            }
        }
        // 2 estrelas pelo utilizador
        System.out.println("Regras: Inserir um número entre 1 e 12.");
        while (estrelas.size() < 2) {
            try {
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
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Por favor, deve inserir um número!" + reset);
                in = new Scanner(System.in);
            }
        }
        // Unimos listas
        chaveUti.addAll(numeros);
        chaveUti.addAll(estrelas);
        return chaveUti;
    }// Validado

    private static void BoletimAleatorio() {
        ArrayList<ArrayList<Integer>> chavesAleatorias = new ArrayList<>();
        ArrayList<Integer> chave = new ArrayList<>();
        System.out.println("\nMenu 3 - Criar um Boletim Aleatorio");
        int chaves = chavesQTD();

        // Ciclo para criar quantidades de chaves
        for (int i = 0; i < chaves; i++) {
            chave = GerarChaveAle();
            chavesAleatorias.add(chave);
        }
        chaveVencedora.clear(); // limpamos chave antes de gerar novos valores
        chaveVencedora = GerarChaveAle();
        CompararChaves(chavesAleatorias);
    }

    private static void BoletimUtilizador() {
        ArrayList<ArrayList<Integer>> chavesUtilizador = new ArrayList<>();
        ArrayList<Integer> chave = new ArrayList<>();

        System.out.println("\nMenu 2 - Criar um Boletim Utilizador");
        System.out.println("Regras: escolha 5 números e 2 estrelas por chave");
        int chaves = chavesQTD();

        // Ciclo para criar quantidades de chaves
        for (int i = 0; i < chaves; i++) {
            System.out.println("<- Chave " + (i + 1) + " ->");
            // Gerar chaves utilizador
            chave = GerarChaveUti();
            // Preenchemos lista principal
            chavesUtilizador.add(chave);
            // Mostramos chave
            MostrarChaves(chavesUtilizador.get(i));
        }
        chaveVencedora.clear(); // limpamos chave antes de gerar novos valores
        chaveVencedora = GerarChaveAle();
        CompararChaves(chavesUtilizador);
    }

    private static int chavesQTD() {
        int n = 0;
        boolean validar = true;
        // Validamos maximo de chaves
        do {
            try {
                System.out.println("Quantas chaves deseja jogar? (Máximo 5)");
                n = in.nextInt();
                if (n > 0 & n <= 5) {
                    validar = false;
                } else {
                    System.out.println("\n*** Quantidade de chaves invalida! ***\n");
                }
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Por favor, deve inserir um número!" + reset);
                in = new Scanner(System.in);
            }
        } while (validar);
        return n;
    } // Validado

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
            // Evaluamos prémios
            String[][] premio = {
                    {"1º Premio", "5", "2"},
                    {"2º Premio", "5", "1"},
                    {"3º Premio", "5", "0"},
                    {"4º Premio", "4", "2"},
                    {"5º Premio", "4", "1"},
                    {"6º Premio", "3", "2"},
                    {"7º Premio", "4", "0"},
                    {"8º Premio", "2", "2"},
                    {"9º Premio", "3", "1"},
                    {"10º Premio", "3", "0"},
                    {"11º Premio", "1", "2"},
                    {"12º Premio", "2", "1"},
                    {"13º Premio", "2", "0"}};
            for (String[] pre : premio) {
                int nu = Integer.parseInt(pre[1]);
                int est = Integer.parseInt(pre[2]);
                if (nu == acertosNum && est == acertosEstre) {
                    System.out.println(verde + "Ganhou o: " + pre[0] + reset + " Números: " + acertosNum + " Estrelas: " + acertosEstre);
                }
            }
            System.out.println(vermelho + "Sem prémio nesta oportunidade." + reset);
        } // Fim ciclo principal
    }

    private static void SimularVencedor() {
        chaveVencedora.clear(); // limpamos chave antes de gerar novos valores
        System.out.println("\nMenu 1 - Simular um sorteio vencedor");
        System.out.print("Chave Vencedora: ");
        chaveVencedora = GerarChaveAle();
        MostrarChaves(chaveVencedora);
    }

    private static ArrayList<Integer> GerarChaveAle() {
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> estrelas = new ArrayList<>();
        ArrayList<Integer> chave = new ArrayList<>();
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
        // Unimos chaves
        chave.addAll(numeros);
        chave.addAll(estrelas);
        return chave;
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