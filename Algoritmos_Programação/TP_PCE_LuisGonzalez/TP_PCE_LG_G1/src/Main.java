import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static ArrayList<Integer> numeros = new ArrayList<Integer>();
    static ArrayList<Integer> estrelas = new ArrayList<Integer>();

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
                case 3:
                case 4:
                default:
            }
        } while (op != 0);

    }

    private static void CriarChave() {
        // 5 numeros
        for (int i = 0; i < 5; i++) {
            int n = rnd.nextInt(1, 51);
            if (!numeros.contains(n)) {
                numeros.add(n);
            } else {
                i--;
            }
        }
        // 2 estrelas
        for (int i = 0; i < 2; i++) {
            int n = rnd.nextInt(1, 12);
            if (!estrelas.contains(n)) {
                estrelas.add(n);
            } else {
                i--;
            }
        }
    }

    private static void SimularVencedor() {
        CriarChave();
        System.out.println(numeros + "|" + estrelas);
    }

}