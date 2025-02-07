package jogo;


import entidades.*;
import items.ArmaPrincipal;
import items.ConsumivelCombate;
import items.Pocao;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private Scanner in = new Scanner(System.in);
    private Random rnd = new Random();
    private Vendedor vendedor;

    /**
     * Método principal do jogo e recebe um herói
     */
    public void onePieceWano(Heroi heroi) {
        // Vendedor
        vendedor = new Vendedor();
        lojaVendedor();

    }

    /**
     * Método onde será explicado o jogo
     */
    public void intro() {
        System.out.println("Intro do jogo, explicacao, etc....");
    }

    /**
     * Método para criar uma personagem
     */
    public Heroi criarPersonagem() {
        intro();

        System.out.println("Escolha um personagem para iniciar o jogo\n1- Luffy\n2- Zoro\n3- Sanji");
        int personagem = Tools.validarEscolha();

        // Dificuldade
        System.out.println("Escolha dificuldade\n1-Fácil\n2-Difícil");
        int dificuldade = Tools.validarEscolha();
        int pontos, ouro;
        if (dificuldade == 1) {
            pontos = 300;
            ouro = 20;
        } else {
            pontos = 220;
            ouro = 15;
        }

        // Distribuir pontos de criação
        System.out.println("Distribua seus pontos de criação: " + pontos + "\n1 ponto de \uD83D\uDCAA = 5 pontos\n1 " +
                "ponto de ❤\uFE0F = 1 ponto");
        int distribuir, vida, forca;
        int MIN_FORCA_PTS = 50;
        int MAX_FORCA_PTS = 100;
        do {
            System.out.println("Forçã (Mín|Max de \uD83D\uDCAA 10| (50pts))");
            distribuir = Tools.validarEscolha();
            if (distribuir >= MIN_FORCA_PTS && distribuir <= pontos) {
                forca = distribuir / 5;
                vida = pontos - distribuir;
                break;
            }
        } while (true);

        return switch (personagem) {
            case 1 -> new Luffy("Luffy", vida, forca, 1, ouro);
            case 2 -> new Zoro("Zoro", vida, forca, 1, ouro);
            case 3 -> new Sanji("Sanji", vida, forca, 1, ouro);
            default -> null;
        };
    }

    /**
     * Método para preencher loja do vendedor (ArrayList loja)
     */
    public void lojaVendedor() {
        // POÇÕES
        vendedor.adicionarItem(new Pocao("Nozes de Wano", 1, 15, 0));
        vendedor.adicionarItem(new Pocao("Maçã Energética", 2, 25, 1));
        vendedor.adicionarItem(new Pocao("Excite Maçã", 3, 30, 5));
        vendedor.adicionarItem(new Pocao("Potente Excite Maçã", 5, 50, 10));
        vendedor.adicionarItem(new Pocao("Cerveja", 1, 25, 1));

        // COMBATE
        vendedor.adicionarItem(new ConsumivelCombate("Estrela Explosiva", 5, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Faca de Cozinha", 5, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Garrafa de Sake", 5, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Pedaço do Mastro Principal", 5, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Bola de Canhão", 5, 20));

        // ARMAS
        vendedor.adicionarItem(new ArmaPrincipal("Chapéu de Palha", 10, 10, 100));
        vendedor.adicionarItem(new ArmaPrincipal("Espada Enma", 10, 10, 100));
        vendedor.adicionarItem(new ArmaPrincipal("Estilingue Kabuto", 10, 10, 100));
        vendedor.adicionarItem(new ArmaPrincipal("Clima-Tact", 10, 10, 100));
        vendedor.adicionarItem(new ArmaPrincipal("Soul Solid", 10, 10, 100));
    }
}
