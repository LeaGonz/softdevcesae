package jogo;


import Enums.Personagem;
import entidades.*;
import itens.ArmaPrincipal;
import itens.ConsumivelCombate;
import itens.Pocao;

import java.util.Scanner;

public class Jogo {
    private static final Scanner in = new Scanner(System.in);

    /**
     * Método principal do jogo e recebe um herói
     */
    public void onePieceWano(Heroi heroi) {
        // LINEA DE PRUEBAS ***********************

        // 1. PERSONAGEM
        heroi.mostrarDetalhes();

        // 2. CRIAR VENDEDOR E LOJA
        Vendedor vendedor = new Vendedor();
        lojaVendedor(vendedor);

        // 3. VENDEDOR ITEMS AO HERÓI
        vender(vendedor, heroi);

        // 4. COMBATE
        combate(heroi);
    }

    /**
     * Método combate entre Herói e NPC
     *
     * @param heroi
     */
    public void combate(Heroi heroi) {
        NPC npc = criarNPC();

        System.out.println(heroi.getNome() + " inicia um combate contra o " + npc.getNome());

        while (heroi.atacar(npc)) {
            System.out.println(heroi.getNome() + " - " + heroi.getHp());
            System.out.println(npc.getNome() + " - " + npc.getHp());
            System.out.println("1- Atacar | 2- Mochila");
            int escolha = Tools.validarEscolhaNum();
            if (escolha == 2) {
                System.out.println("Mochila");
                break;
            }
        }
        heroi.mostrarDetalhes();
    }

    /**
     * Método para criar uma personagem
     */
    public Heroi criarPersonagem() {
        // CONSTANTES
        int NIVEL_INI = 1;
        int FORCA_MIN = 50;
        int PONTOS_FORCA = 5;
        int PONTOS, OURO, FORCA_MAX;

        System.out.println("Escolha um personagem para iniciar o jogo\n1- Luffy\n2- Zoro\n3- Sanji");
        int personagem = Tools.validarEscolhaNum();

        // DIFICULDADE
        System.out.println("Escolha dificuldade\n1-Fácil\n2-Difícil");
        int dificuldade = Tools.validarEscolhaNum();
        if (dificuldade == 1) {
            PONTOS = 300;
            OURO = 20;
            FORCA_MAX = 200;
        } else {
            PONTOS = 220;
            OURO = 15;
            FORCA_MAX = 120;
        }

        // DISTRIBUIR PONTOS DE CRIACAO
        System.out.println("Distribua seus pontos de criação: " + PONTOS + "\n1 pt de \uD83D\uDCAA = 5 pts\n1 " +
                "pt de ❤\uFE0F = 1 pt");
        int distribuir, vida, forca;

        do {
            System.out.println("Forçã \uD83D\uDCAA(Mín|Max " + (FORCA_MIN / PONTOS_FORCA) + "|" + (FORCA_MAX / PONTOS_FORCA) + " -> (" + FORCA_MIN + "|" + FORCA_MAX + "pts))");
            distribuir = Tools.validarEscolhaNum();
            if (distribuir >= FORCA_MIN && distribuir <= PONTOS) {
                forca = distribuir / PONTOS_FORCA;
                vida = PONTOS - distribuir;
                break;
            }
        } while (true);

        return switch (personagem) {
            case 1 -> new Luffy(Personagem.Luffy, vida, forca, NIVEL_INI, OURO);
            case 2 -> new Zoro(Personagem.Zoro, vida, forca, NIVEL_INI, OURO);
            case 3 -> new Sanji(Personagem.Sanji, vida, forca, NIVEL_INI, OURO);
            default -> null;
        };
    }

    /**
     * Método para criar um NPC
     *
     * @return
     */
    public NPC criarNPC() {
        return new NPC(Personagem.NPC, 100, 50, 5);
    }

    /**
     * Método para preencher loja do vendedor (ArrayList loja)
     */
    public void lojaVendedor(Vendedor vendedor) {
        // POÇÕES
        vendedor.adicionarItem(new Pocao("Nozes de Wano", 1, Personagem.Geral, 15, 0));
        vendedor.adicionarItem(new Pocao("Maçã Energética", 2, Personagem.Geral, 25, 1));
        vendedor.adicionarItem(new Pocao("Excite Maçã", 3, Personagem.Geral, 30, 5));
        vendedor.adicionarItem(new Pocao("Potente Excite Maçã", 5, Personagem.Geral, 50, 10));
        vendedor.adicionarItem(new Pocao("Cerveja", 1, Personagem.Geral, 25, 1));

        // COMBATE
        vendedor.adicionarItem(new ConsumivelCombate("Estrela Explosiva", 5, Personagem.Usopp, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Faca de Cozinha", 5, Personagem.Sanji, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Garrafa de Sake", 5, Personagem.Zoro, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Pedaço do Mastro Principal", 5, Personagem.Luffy, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Bola de Canhão", 5, Personagem.Geral, 20));

        // ARMAS
        vendedor.adicionarItem(new ArmaPrincipal("Chapéu de Palha", 10, 10, 100, Personagem.Luffy));
        vendedor.adicionarItem(new ArmaPrincipal("Espada Enma", 10, 10, 100, Personagem.Zoro));
        vendedor.adicionarItem(new ArmaPrincipal("Estilingue Kabuto", 10, 10, 100, Personagem.Usopp));
        vendedor.adicionarItem(new ArmaPrincipal("Clima-Tact", 10, 10, 100, Personagem.Nami));
        vendedor.adicionarItem(new ArmaPrincipal("Soul Solid", 10, 10, 100, Personagem.Brook));
    }

    public void vender(Vendedor vendedor, Heroi heroi) {
        Historia.vendedorIntro();
        if (Tools.validarSimNao()) {
            do {
                vendedor.mostrarLoja();
                Historia.vendedorPergunta();
                vendedor.vender(heroi);
                Historia.vendedorPerguntaMais();
            } while (Tools.validarSimNao());
        }
    }
}
