package jogo;


import Enums.Personagem;
import entidades.*;
import itens.ArmaPrincipal;
import itens.ConsumivelCombate;
import itens.Pocao;

import java.util.Random;
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
        Historia.vendedorIntro();
        vender(vendedor, heroi);

        // 1er VILA KOSUKI
        vilaKosuki(heroi, vendedor);

        // 2da VILA
        vilaLamentos(heroi, vendedor);
    }

    private boolean vilaLamentos(Heroi heroi, Vendedor vendedor) {
        //HISTORIA
        Historia.vilaLamentosIntro();
        Historia.vilaLamentos();

        //MISSÁO
        boolean missao = true;
        boolean jardim = true;
        do {

            Historia.vilaLamentosAto1();

            //ESCOLHER CAMINHO
            int caminho = Tools.validarEscolhaNum(1, 4);
            switch (caminho) {
                case 1: // ENEMIGO
                    missao = combate(heroi);
                    break;
                case 2: //  VENDEDOR
                    Historia.vendedorAparece();
                    vender(vendedor, heroi);
                    break;
                case 3: // ARMADILHA
                    if (jardim) {
                        jardim = armadilha2(heroi);
                    } else {
                        System.out.println(Tools.color.RED + "'Hmm, já estive neste jardim antes. Nada de ouro desta vez... que desilusão.'" + Tools.color.WHITE_BRIGHT);
                    }
                    break;
                case 4: // POÇÕES
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
            }

        } while (missao);
        return false;
    }

    private boolean vilaKosuki(Heroi heroi, Vendedor vendedor) {
        //HISTORIA
        Historia.vilaKozukiIntro();
        Historia.vilaKozuki();

        //MISSÁO
        boolean missao = true;
        do {
            Historia.vilaKozukiAto1();

            //ESCOLHER CAMINHO
            int caminho = Tools.validarEscolhaNum(1, 4);
            switch (caminho) {
                case 1: // VENDEDOR
                    Historia.vendedorAparece();
                    vender(vendedor, heroi);
                    break;
                case 2: // ENEMIGO
                    missao = combate(heroi);
                    break;
                case 3: // ARMADILHA
                    missao = armadilha(heroi);
                    break;
                case 4: // PoÇÕES
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
            }

        } while (missao);

        return false;
    }

    private boolean armadilha(Heroi heroi) {
        Historia.vilaKozukiTemplo();

        // RANDOM 20% subir nível e 80% inimigo
        Random rnd = new Random();
        int numRnd = rnd.nextInt(1, 101);

        if (numRnd <= 20) {
            Historia.vilaKozukiItemLendario();
            heroi.subirNivel();
            heroi.mostrarDetalhes();
            return true;
        } else {
            return combate(heroi);
        }
    }

    private boolean armadilha2(Heroi heroi) {
        Historia.vilaLamentosJardim();

        // RANDOM 10% encontrar ouro
        Random rnd = new Random();
        int numRnd = rnd.nextInt(1, 101);

        if (numRnd <= 10) {
            Historia.vilaLamentosJardimOuro();
            heroi.mostrarDetalhes();
            return false;
        } else {
            Historia.vilaLamentosJardimNada();
            return true;
        }
    }

    /**
     * Método combate entre Herói e NPC
     *
     * @param heroi
     */
    public boolean combate(Heroi heroi) {
        // Criamos NPC para o combate
        NPC npc = criarNPC();

        Historia.combateIntro(heroi, npc);

        // Ciclo principal do combate
        do {
            // Separador do combate
            System.out.printf(Tools.color.BLUE + """
                            
                            
                            ﹏﹏﹏﹏﹏﹏﹏﹏﹏%s\uD80C\uDE9D%s﹏﹏﹏﹏﹏﹏﹏﹏﹏ %s%s VS %s%s ﹏﹏﹏﹏﹏﹏﹏﹏﹏%s\uD80C\uDE9D%s﹏﹏﹏﹏﹏﹏﹏﹏﹏
                            
                            """ + Tools.color.WHITE_BRIGHT,
                    Tools.color.YELLOW, Tools.color.BLUE, Tools.color.RED, heroi.getNome(),
                    npc.getNome(), Tools.color.BLUE, Tools.color.YELLOW, Tools.color.BLUE);

            mostrarBarraHP(heroi, npc);

        } while (heroi.atacar(npc));

        // Terminar combate
        if (npc.getHp() == 0) {
            Historia.combateGanhaHeroi(heroi);
            heroi.mostrarDetalhes();
            Tools.pausar();
            return false;
        } else {
            Historia.combateGanhaNPC(heroi);
            return true;
        }
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
        vendedor.adicionarItem(new ArmaPrincipal("Espada Enma ⚔️", 10, 10, 100, Personagem.Zoro));
        vendedor.adicionarItem(new ArmaPrincipal("Estilingue Kabuto 🎯", 10, 10, 100, Personagem.Usopp));
        vendedor.adicionarItem(new ArmaPrincipal("Clima-Tact ⛈️", 10, 10, 100, Personagem.Nami));
        vendedor.adicionarItem(new ArmaPrincipal("Soul Solid 💀", 10, 10, 100, Personagem.Brook));
    }

    /**
     * Método vender ao herói. Passamos herói ao método vender()
     *
     * @param vendedor
     * @param heroi
     */
    public void vender(Vendedor vendedor, Heroi heroi) {
        if (Tools.validarSimNao()) {
            do {
                vendedor.mostrarLoja();
                Historia.vendedorPergunta();
            } while (vendedor.vender(heroi));
        } else {
            Historia.vendedorDespedida();
        }
        vendedor.limparItensMostrados();
    }

    /**
     * Método para criar uma barra de vida que muda de cor
     *
     * @param heroi
     * @param npc
     */
    public static void mostrarBarraHP(Heroi heroi, NPC npc) {
        int barraLargura = 20;
        String barra = "";

        System.out.println("\n" + Tools.color.WHITE_BRIGHT + heroi.getNome() + "                     " + Tools.color.RED_BRIGHT +
                "VS"
                + Tools.color.WHITE_BRIGHT + "  " + npc.getNome());

        System.out.println("HP: " + corBarra(heroi.getHp(), heroi.getMaxHp(), barraLargura) +
                "     " + corBarra(npc.getHp(), npc.getMaxHp(), barraLargura) + Tools.color.WHITE_BRIGHT + " :HP\n");

    }

    /**
     * Método complementar para criar cada barra Herói/NPC
     *
     * @param hp
     * @param maxHp
     * @param barraLargura
     * @return o String barra
     */
    public static String corBarra(int hp, int maxHp, int barraLargura) {
        String barra = "";

        // Calculo em percentagem da barra
        double percenHP = (double) hp / maxHp;
        int caracteresVerdes = (int) (percenHP * barraLargura);

        String color;
        if (percenHP > 0.5) {
            color = Tools.color.GREEN_BRIGHT;
        } else if (percenHP > 0.25) {
            color = Tools.color.YELLOW_BRIGHT;
        } else {
            color = Tools.color.RED_BRIGHT;
        }

        // Construimos a barra segundo a largura máxima 20
        for (int i = 0; i < barraLargura; i++) {
            if (i < caracteresVerdes) {
                barra += color + "█";
            } else {
                barra += "\u001B[0m" + "░";
            }
        }
        return barra;
    }
}
