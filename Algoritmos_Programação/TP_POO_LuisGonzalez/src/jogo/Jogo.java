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
        // 1. PERSONAGEM
        heroi.mostrarDetalhes();
        Tools.pausar();

        // 2. CRIAR VENDEDOR E LOJA
        Vendedor vendedor = new Vendedor();
        lojaVendedor(vendedor);

        // 3. VENDEDOR ITEMS AO HERÓI
        vender(vendedor, heroi);

        // 4. COMBATE
        combate(heroi);
    }

    /**
     * Método para escolher dificuldade do jogo, distribuir pontos de criação e criar a personagem principal
     */
    public Heroi criarPersonagem() {
        // CONSTANTES
        int NIVEL_INI = 1;
        int PONTOS = 0;
        int PONTOS_MIN = 50;
        int PONTOS_MAX = 0;
        int PONTOS_FORCA = 5;
        int OURO = 0;

        // PERSONAGEM
        Historia.escolhaPersonagem();

        int personagem = Tools.validarEscolhaNum(1, 3);

        // DIFICULDADE
        Historia.escolhaDificuldade();

        int dificuldade = Tools.validarEscolhaNum(1, 2);
        if (dificuldade == 1) {
            PONTOS = 300;
            OURO = 20;
            PONTOS_MAX = 200;
        } else if (dificuldade == 2) {
            PONTOS = 220;
            OURO = 15;
            PONTOS_MAX = 120;
        }

        // DISTRIBUIR PONTOS DE CRIACAO
        Historia.escolhaPontos(PONTOS, PONTOS_MIN, PONTOS_FORCA, PONTOS_MAX);
        int distribuir, vida, forca;

        do {
            distribuir = Tools.validarEscolhaNum(PONTOS_MIN, PONTOS);

            if (distribuir >= PONTOS_MIN && distribuir <= PONTOS_MAX) {
                forca = distribuir / PONTOS_FORCA;
                vida = PONTOS - distribuir;
                break;
            } else {
                System.out.println("Pontos de força 💪 inválidos");
            }
        } while (true);

        switch (personagem) {
            case 1:
                Historia.luffyIntro();
                return new Luffy(Personagem.Luffy, vida, forca, NIVEL_INI, OURO);
            case 2:
                Historia.zoroIntro();
                return new Zoro(Personagem.Zoro, vida, forca, NIVEL_INI, OURO);
            case 3:
                Historia.sanjiIntro();
                return new Sanji(Personagem.Sanji, vida, forca, NIVEL_INI, OURO);
            default:
                return null;
        }
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
        }
        heroi.mostrarDetalhes();
    }



    /**
     * Método para criar um NPC
     *
     * @return
     */
    public NPC criarNPC() {
        return new NPC(Personagem.NPC, 100, 15, 5);
    }

    /**
     * Método para preencher loja do vendedor (ArrayList loja)
     */
    public void lojaVendedor(Vendedor vendedor) {
        // POÇÕES
        vendedor.adicionarItem(new Pocao("Nozes de Wano 🍥", 1, Personagem.Geral, 15, 0));
        vendedor.adicionarItem(new Pocao("Maçã Energética 🍎", 2, Personagem.Geral, 0, 10));
        vendedor.adicionarItem(new Pocao("Excite Maçã 🍏", 3, Personagem.Geral, 5, 15));
        vendedor.adicionarItem(new Pocao("Potente Excite Maçã 💮", 5, Personagem.Geral, 10, 20));
        vendedor.adicionarItem(new Pocao("Cerveja 🍺", 1, Personagem.Geral, 25, 1));

        // COMBATE
        vendedor.adicionarItem(new ConsumivelCombate("Estrela Explosiva 💥", 5, Personagem.Usopp, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Faca de Cozinha 🔪", 5, Personagem.Sanji, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Garrafa de Sake 🍶", 5, Personagem.Zoro, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Pedaço do Mastro Principal 🪵", 5, Personagem.Luffy, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Bola de Canhão 💣", 5, Personagem.Geral, 20));

        // ARMAS
        vendedor.adicionarItem(new ArmaPrincipal("Chapéu de Palha 👒", 10, 10, 100, Personagem.Luffy));
        vendedor.adicionarItem(new ArmaPrincipal("Espada Enma ️🗡", 10, 10, 100, Personagem.Zoro));
        vendedor.adicionarItem(new ArmaPrincipal("Estilingue Kabuto 🎯", 10, 10, 100, Personagem.Usopp));
        vendedor.adicionarItem(new ArmaPrincipal("Clima-Tact ✨", 10, 10, 100, Personagem.Nami));
        vendedor.adicionarItem(new ArmaPrincipal("Soul Solid 💀", 10, 10, 100, Personagem.Brook));
    }

    public void vender(Vendedor vendedor, Heroi heroi) {
        Historia.vendedorIntro();
        if (Tools.validarSimNao()) {
            do {
                vendedor.mostrarLoja();
                Historia.vendedorPergunta();
                vendedor.vender(heroi);
                heroi.mostrarDetalhes();
                Historia.vendedorPerguntaMais();
            } while (Tools.validarSimNao());
        }
    }
}
