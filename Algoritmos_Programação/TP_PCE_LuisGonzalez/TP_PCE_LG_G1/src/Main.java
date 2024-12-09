import java.util.*;

public class Main {
    public static final String reset = "\033[0m";
    public static final String vermelho = "\033[0;31m";
    public static final String verde = "\033[0;32m";
    public static final String amarelo = "\033[0;33m";

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static int[] chave_vence = new int[7];
    static int[][] chave_uti;

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
            System.out.println("BEM-VINDO AO EUROMILHÕES");
            System.out.println("Regras: escolha 5 números e 2 estrelas por chave");
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
                    BoletimUtili();
                    break;
                case 3:
                case 4:
                default:
            }
        } while (op != 0);

    }

    private static void ChaveVencedora() {
        // Gerar list temp com todos os numeros
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            temp.add(i + 1);
        }
        for (int i = 0; i < 12; i++) {
            temp.add(i + 1);
        }
        // Preenchemos chave vencedora com temp
        int index;
        for (int i = 0; i < 7; i++) {
            if (i < 5) {
                // 5 numeros
                index = rnd.nextInt((50 - i));
            } else {
                // 2 estrelas
                index = rnd.nextInt((45), temp.size());
            }
            chave_vence[i] = temp.get(index);
            // Eliminamos valores do temp para evitar duplicados
            temp.remove(index);
        }
    }

    private static void BoletimUtili() {
        ChaveVencedora(); // Criamos chave vencedora

        System.out.println("BEM-VINDO AO EUROMILHÕES");
        System.out.println("Regras: escolha 5 números e 2 estrelas por chave");
        System.out.println("Quantas chaves deseja jogar? (Máximo 5)");
        int chaves = in.nextInt();
        chave_uti = new int[chaves][7];

        // Criamos chaves
        System.out.println("\nEscolha 5 números e 2 estrelas por chave");
        for (int i = 0; i < chaves; i++) {
            System.out.println("Chave " + (i + 1));
            // 5 numeros
            for (int j = 0; j < 5; j++) {
                System.out.print("numero " + (j + 1) + ":");
                chave_uti[i][j] = in.nextInt();
            }
            for (int k = 0; k < 2; k++) {
                System.out.print("Estrela " + (k + 1) + ":");
                chave_uti[i][5 + k] = in.nextInt();
            }
        }
        // Fim Criamos chaves
        CompararChaves();

        //MostrarChave();
    }

    private static void CompararChaves() {
        for (int i = 0; i < chave_uti.length; i++) {
            for (int j = 0; j < chave_uti[i].length; j++) {
                System.out.println();
            }
        }
    }

    private static void MostrarChave() {
        System.out.println("Chave");
        // 50 numeros
        for (int j = 1; j < 51; j++) {
            System.out.printf("%2d|", j);
            if ((j) % 6 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        // 12 estrelas
        for (int j = 1; j < 13; j++) {
            System.out.printf("<%2d> ", j);
            if ((j) % 3 == 0) {
                System.out.println();
            }
        }
    }

    private static void SimularVencedor() {
        ChaveVencedora();
        System.out.print("Chave Vencedora: ");
        // Ordenar chave vencedora
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < chave_vence.length - 2; i++) {
            temp.add(chave_vence[i]);
        }
        Collections.sort(temp);
        for (int i : temp) {
            System.out.print(verde + "|" + i);
        }
        temp.clear();
        for (int i = 5; i < chave_vence.length; i++) {
            temp.add(chave_vence[i]);
        }
        Collections.sort(temp);
        for (int i : temp) {
            System.out.print(amarelo + "<" + i + ">" + reset);
        }
        temp.clear();
    }
}