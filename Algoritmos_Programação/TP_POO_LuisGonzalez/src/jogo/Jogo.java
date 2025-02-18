package jogo;


import Enums.Personagem;
import entidades.*;
import itens.ArmaPrincipal;
import itens.ConsumivelCombate;
import itens.Pocao;

import java.util.Random;
import java.util.Scanner;

import static entidades.NPC.criarNPC;

/**
 * Classe principal do jogo, responsável por controlar a progressão da história,
 * batalhas, interações com NPCs e mecânicas principais.
 */
public class Jogo {
    private static final Scanner in = new Scanner(System.in);
    private static Random rnd = new Random();
    private Personagem npcBoss;

    /**
     * Método principal do jogo. Controla a progressão do jogador pelas vilas
     * O jogo termina ao vencer Kaido ou ao perder
     *
     * @param heroi
     * @return Retorna {@code true} se o jogador for derrotado, {@code false} se completar a história.
     */
    public boolean onePieceWano(Heroi heroi) {
        // 1. PERSONAGEM
        heroi.mostrarDetalhes();
        Tools.pausar();

        // 2. CRIAR VENDEDOR E LOJA
        Vendedor vendedor = new Vendedor();
        lojaVendedor(vendedor);

        // 3. VENDEDOR ITEMS AO HERÓI
        Historia.vendedorIntro();
        vender(vendedor, heroi);

        // 1 VILA KOSUKI
        if (vilaKosuki(heroi, vendedor)) return true;

        // 2 VILA LAMENTOS
        if (vilaLamentos(heroi, vendedor)) return true;

        // 3 VILA HAKUMAI
        if (vilaHakumai(heroi, vendedor)) return true;

        // 4 VILA AMIGASA
        if (vilaAmigasa(heroi, vendedor)) return true;

        // 5 VILA RENGOKU
        if (vilaRengoku(heroi, vendedor)) return true;

        // 6 KAIDO ONIGASHIMA
        if (onigashima(heroi, vendedor)) return true;

        // 7 HISTORIA FINAL
        Historia.finalWano();

        return false;
    }

    /**
     * Progressão e eventos da vilaHakumai
     *
     * @param heroi
     * @param vendedor
     * @return Retorna {@code true} se o jogador for derrotado, {@code false} se continuar.
     */
    private boolean vilaHakumai(Heroi heroi, Vendedor vendedor) {
        //HISTORIA
        Historia.vilaHakumaiIntro();
        Historia.vilaHakumai();

        //MISSÁO
        boolean mansao = true;
        do {
            Historia.vilaHakumaiAto1();

            //ESCOLHER CAMINHO
            int caminho = Tools.validarEscolhaNum(1, 4);
            switch (caminho) {
                case 1: // VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 2: // ENEMIGO
                    return combate(heroi);
                case 3: // ARMADILHA
                    if (mansao) {
                        mansao = armadilha3(heroi);
                    } else {
                        System.out.println(Tools.color.RED + "\n'Hmm, já estive nesta mansão antes'\n" +
                                Tools.color.WHITE_BRIGHT);
                        Tools.pausar();
                    }
                    break;
                case 4: // POÇÕES
                    heroi.mostrarDetalhes();
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
            if (heroi.getHp() == 0) return true;
        } while (true);
    }

    /**
     * Progressão e eventos da vilaKosuki
     *
     * @param heroi
     * @param vendedor
     * @return Retorna {@code true} se o jogador for derrotado, {@code false} se continuar.
     */
    private boolean vilaKosuki(Heroi heroi, Vendedor vendedor) {
        //HISTORIA
        Historia.vilaKozukiIntro();
        Historia.vilaKozuki();

        //MISSÁO
        boolean templo = true;
        do {
            Historia.vilaKozukiAto1();
            //ESCOLHER CAMINHO
            int caminho = Tools.validarEscolhaNum(1, 4);
            switch (caminho) {
                case 1: // VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 2: // ENEMIGO
                    return combate(heroi);
                case 3: // ARMADILHA
                    if (templo) {
                        templo = armadilha(heroi);
                    } else {
                        System.out.println(Tools.color.RED + "\n'Hmm, já estive neste templo antes'\n" +
                                Tools.color.WHITE_BRIGHT);
                        Tools.pausar();
                    }
                    break;
                case 4: // POÇÕES
                    heroi.mostrarDetalhes();
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
            if (heroi.getHp() == 0) return true;
        } while (true);
    }

    /**
     * Progressão e eventos da vilaLamentos
     *
     * @param heroi
     * @param vendedor
     * @return Retorna {@code true} se o jogador for derrotado, {@code false} se continuar.
     */
    private boolean vilaLamentos(Heroi heroi, Vendedor vendedor) {
        //HISTORIA
        Historia.vilaLamentosIntro();
        Historia.vilaLamentos();

        //MISSÁO
        boolean jardim = true;
        do {
            Historia.vilaLamentosAto1();
            //ESCOLHER CAMINHO
            int caminho = Tools.validarEscolhaNum(1, 4);
            switch (caminho) {
                case 1: // ENEMIGO
                    return combate(heroi);
                case 2: //  VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 3: // ARMADILHA
                    if (jardim) {
                        jardim = armadilha2(heroi);
                    } else {
                        System.out.println(Tools.color.RED + "\n'Hmm, já estive neste jardim antes. Nada de ouro " +
                                "desta vez... que desilusão.'\n" + Tools.color.WHITE_BRIGHT);
                        Tools.pausar();
                    }
                    break;
                case 4: // POÇÕES
                    heroi.mostrarDetalhes();
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
            if (heroi.getHp() == 0) return true;

        } while (true);
    }

    /**
     * Progressão e eventos da vilaAmigasa
     *
     * @param heroi
     * @param vendedor
     * @return Retorna {@code true} se o jogador for derrotado, {@code false} se continuar.
     */
    private boolean vilaAmigasa(Heroi heroi, Vendedor vendedor) {
        //HISTORIA
        Historia.vilaAmigasaIntro();
        Historia.vilaAmigasa();

        //MISSÁO
        boolean fonte = true;
        do {
            Historia.vilaAmigasaAto1();
            //ESCOLHER CAMINHO
            int caminho = Tools.validarEscolhaNum(1, 4);
            switch (caminho) {
                case 1: // ENEMIGO
                    return combate(heroi);
                case 2: // ARMADILHA
                    if (fonte) {
                        fonte = armadilha4(heroi);
                    } else {
                        System.out.println(Tools.color.RED + "\n'Hmm, já estive nesta fonte antes'\n" +
                                Tools.color.WHITE_BRIGHT);
                        Tools.pausar();
                    }
                    break;
                case 3: // VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 4: // POÇÕES
                    heroi.mostrarDetalhes();
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
            if (heroi.getHp() == 0) return true;

        } while (true);
    }

    /**
     * Progressão e eventos da vilaRengoku
     *
     * @param heroi
     * @param vendedor
     * @return Retorna {@code true} se o jogador for derrotado, {@code false} se continuar.
     */
    private boolean vilaRengoku(Heroi heroi, Vendedor vendedor) {
        //HISTORIA
        Historia.vilaRengokuIntro();
        Historia.vilaRengoku();

        //MISSÁO
        boolean tumulo = true;
        do {
            Historia.vilaRengokuAto1();
            //ESCOLHER CAMINHO
            int caminho = Tools.validarEscolhaNum(1, 4);
            switch (caminho) {
                case 1: // INIMIGO
                    return combate(heroi);
                case 2: // ARMADILHA
                    if (tumulo) {
                        tumulo = armadilha5(heroi);
                    } else {
                        System.out.println(Tools.color.RED + "\n'Hmm, já estive nestos túmulos'\n" +
                                Tools.color.WHITE_BRIGHT);
                        Tools.pausar();
                    }
                    break;
                case 3: // VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 4: // POÇÕES
                    heroi.mostrarDetalhes();
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
            if (heroi.getHp() == 0) return true;

        } while (true);
    }

    /**
     * Método que gerencia os eventos, missões e batalhas na etapa final de Onigashima,
     * onde o jogador controla diferentes personagens (Sanji, Zoro e Luffy)
     * Este método inclui:
     *   compra itens ou usa poções.
     * - A batalha final entre Luffy e Kaido.
     * @param heroi O herói que o jogador controla. Este personagem será alterado durante o método.
     * @param vendedor
     * @return Retorna {@code true} se o jogador perder alguma das batalhas, {@code false} se vencer todas.
     */
    private boolean onigashima(Heroi heroi, Vendedor vendedor) {
        //HISTORIA
        Historia.kaidoChegada();

        Historia.kaidoIntro();
        Historia.kaidoOnigashima();

        /***************** MISSÃO SANJI *****************/
        boolean sanji = true;

        // MUDAMOS HERÓI E ITENS (SE HOUVER)
        heroi = heroi.mudarHeroi(Personagem.Sanji);
        Historia.kaidoSanji();
        heroi.mostrarDetalhes();

        do {
            //ESCOLHER CAMINHO
            Historia.kaidoSanjiEscolha();
            int caminho = Tools.validarEscolhaNum(1, 3);
            switch (caminho) {
                case 1: // INIMIGO
                    npcBoss = Personagem.Queen;
                    sanji = combate(heroi);
                    if (sanji) return sanji;
                    break;
                case 2: // VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 3: // POÇÕES
                    heroi.mostrarDetalhes();
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }

        } while (sanji);

        /***************** MISSÃO ZORO *****************/
        boolean zoro = true;

        // MUDAMOS HERÓI E ITENS (SE HOUVER)
        heroi = heroi.mudarHeroi(Personagem.Zoro);
        Historia.kaidoZoro();
        heroi.mostrarDetalhes();

        do {
            //ESCOLHER CAMINHO
            Historia.kaidoZoroEscolha();
            int caminho = Tools.validarEscolhaNum(1, 3);
            switch (caminho) {
                case 1: // INIMIGO
                    npcBoss = Personagem.King;
                    zoro = combate(heroi);
                    if (zoro) return zoro;
                    break;
                case 2: // VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 3: // POÇÕES
                    heroi.mostrarDetalhes();
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
        } while (zoro);

        /***************** BATALHA FINAL LUFFY VS KAIDO *****************/
        // MUDAMOS HERÓI E ITENS (SE HOUVER)
        heroi = heroi.mudarHeroi(Personagem.Luffy);
        Historia.kaidoLuffy();
        heroi.mostrarDetalhes();

        do {
            //ESCOLHER CAMINHO
            Historia.kaidoLuffyEscolha();
            int caminho = Tools.validarEscolhaNum(1, 3);
            switch (caminho) {
                case 1: // INIMIGO
                    npcBoss = Personagem.Kaido;
                    return combate(heroi);
                case 2: // VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 3: // POÇÕES
                    heroi.mostrarDetalhes();
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
        } while (true);
    }

    /**
     * Método que gerencia uma armadilha em Vila Kozuki, onde o jogador pode
     * ganhar um nível ou enfrentar um inimigo aleatório.
     * @param heroi
     * @return Retorna {@code false} se o herói subir de nível
     * e {@code true} se o herói for derrotado em combate.
     */
    private boolean armadilha(Heroi heroi) {
        Historia.vilaKozukiTemplo();

        // RANDOM 20% subir nível e 80% inimigo
        int numRnd = rnd.nextInt(1, 101);

        if (numRnd <= 20) {
            Historia.vilaKozukiItemLendario();
            heroi.subirNivel();
            heroi.mostrarDetalhes();
            Tools.pausar();
            return false;
        } else {
            return combate(heroi);
        }
    }

    /**
     * Método que gerencia uma armadilha em Vila Lamentos, onde o jogador pode
     * encontrar ouro com 10% de chance, ou nada
     *
     * @param heroi
     * @return Retorna {@code false} se o herói encontrar ouro, {@code true} se o herói for derrotado.
     */
    private boolean armadilha2(Heroi heroi) {
        Historia.vilaLamentosJardim();

        // RANDOM 10% encontrar ouro
        int numRnd = rnd.nextInt(1, 101);

        if (numRnd <= 10) {
            Historia.vilaLamentosJardimOuro();
            heroi.setOuro(5);
            heroi.mostrarDetalhes();
            Tools.pausar();
            return false;
        } else {
            Historia.vilaLamentosJardimNada();
            return true;
        }
    }

    /**
     * Método que gerencia uma armadilha em Vila Hakumai, onde o jogador pode
     * encontrar ouro com 5% de chance ou uma poção com 5% de chance ou
     * inimigo
     * @param heroi
     * @return Retorna {@code false} se o herói encontrar ouro ou poção, {@code true} se o herói for derrotado.
     */
    private boolean armadilha3(Heroi heroi) {
        Historia.vilaHakumaiMansao();
        // RANDOM 5% encontrar ouro
        int numRnd = rnd.nextInt(1, 101);

        if (numRnd <= 5) {
            Historia.vilaHakumaiMansaoOuro();
            heroi.setOuro(10);
            heroi.mostrarDetalhes();
            Tools.pausar();
            return false;
        } else if (numRnd <= 10) {
            Historia.vilaHakumaiMansaoPocao();
            heroi.setInventario(new Pocao("Zumo de Wano 🧪", 1, Personagem.Geral, 50, 0));
            return false;
        } else {
            return combate(heroi);
        }
    }

    /**
     * Método que gerencia uma armadilha em Vila Amigasa, onde o jogador pode
     * encontrar um item de ataque consumível com 15% de chance ou inimigo
     *
     * @param heroi
     * @return Retorna {@code false} se o herói encontrar um item de ataque, {@code true} se o herói for derrotado.
     */
    private boolean armadilha4(Heroi heroi) {
        Historia.vilaAmigasaFonte();

        // RANDOM 15% de encontrar um ataque consumível
        int numRnd = rnd.nextInt(1, 101);

        if (numRnd <= 15) {
            Historia.vilaAmigasaItem();
            heroi.setInventario(new ConsumivelCombate("Bola de Canhão 💣", 5, Personagem.Geral, 20));
            return false;
        } else {
            return combate(heroi);
        }
    }

    /**
     * Método que gerencia uma armadilha em Vila Rengoku, onde o jogador pode
     * encontrar um item lendário com 3% de chance ou inimigo
     *
     * @param heroi
     * @return Retorna {@code false} se o herói encontrar um item lendário, {@code true} se o herói for derrotado.
     */
    private boolean armadilha5(Heroi heroi) {
        Historia.vilaRengokuTumulos();

        // RANDOM 3% de encontrar um item lendário
        int numRnd = rnd.nextInt(1, 101);

        if (numRnd <= 3) {
            Historia.vilaRengokuItem();
            heroi.setInventario(new Pocao("🍎 Maça Rengoku 💥", 0, Personagem.Geral, 200, 200));
            return false;
        } else {
            return combate(heroi);
        }
    }


    private void vilaVender(Vendedor vendedor, Heroi heroi) {
        Historia.vendedorAparece();
        vender(vendedor, heroi);
    }

    /**
     * Método combate entre o herói e um NPC inimigo.
     * @param heroi
     * @return Retorna {@code false} se o herói vencer e continuar o jogo, {@code true} se for derrotado.
     */
    public boolean combate(Heroi heroi) {
        // Criamos NPC para o combate
        NPC npc;
        if (npcBoss == null) {
            npc = criarNPC(heroi);
        } else {
            npc = criarNPC(heroi, npcBoss);
        }

        Historia.combateIntro(heroi, npc);

        // Ciclo principal do combate
        do {
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
     * Método responsável por criar o personagem principal do jogo. O jogador escolhe entre três personagens
     * (Luffy, Zoro ou Sanji), define a dificuldade e distribui pontos de atributos (vida e força) com base na escolha de dificuldade.
     * O personagem criado recebe os atributos iniciais e um valor de ouro.
     * @return Retorna uma instância do personagem
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
     * Inicializa a loja do vendedor e adiciona os itens disponíveis para compra.
     * @param vendedor
     */
    public void lojaVendedor(Vendedor vendedor) {
        // POÇÕES
        vendedor.adicionarItem(new Pocao("Nozes de Wano 🍥", 1, Personagem.Geral, 25, 0));
        vendedor.adicionarItem(new Pocao("Maçã Energética 🍎", 2, Personagem.Geral, 5, 15));
        vendedor.adicionarItem(new Pocao("Excite Maçã 🍏", 3, Personagem.Geral, 60, 2));
        vendedor.adicionarItem(new Pocao("Potente Excite Maçã 💮", 8, Personagem.Geral, 100, 7));
        vendedor.adicionarItem(new Pocao("Cerveja 🍺", 2, Personagem.Geral, 40, 2));

        // COMBATE
        vendedor.adicionarItem(new ConsumivelCombate("Estrela Explosiva 💥", 5, Personagem.Usopp, 30));
        vendedor.adicionarItem(new ConsumivelCombate("Faca de Cozinha 🔪", 5, Personagem.Sanji, 30));
        vendedor.adicionarItem(new ConsumivelCombate("Garrafa de Sake 🍶", 5, Personagem.Zoro, 30));
        vendedor.adicionarItem(new ConsumivelCombate("Pedaço do Mastro Principal 🪵", 5, Personagem.Luffy, 20));
        vendedor.adicionarItem(new ConsumivelCombate("Bola de Canhão 💣", 5, Personagem.Geral, 30));

        // ARMAS
        vendedor.adicionarItem(new ArmaPrincipal("Chapéu de Palha 👒", 10, 10, 60, Personagem.Luffy));
        vendedor.adicionarItem(new ArmaPrincipal("Espada Enma ⚔️", 10, 10, 60, Personagem.Zoro));
        vendedor.adicionarItem(new ArmaPrincipal("Estilingue Kabuto 🎯", 10, 10, 60, Personagem.Usopp));
        vendedor.adicionarItem(new ArmaPrincipal("Clima-Tact ⛈️", 10, 10, 60, Personagem.Nami));
        vendedor.adicionarItem(new ArmaPrincipal("Diable Jambe Boots 🔥", 10, 10, 60, Personagem.Sanji));
    }

    /**
     * Gerencia a interação entre o herói e o vendedor, permitindo a compra de itens.
     * Se o jogador tiver ouro suficiente, ele pode comprar itens repetidamente até decidir parar ou ficar sem dinheiro.
     * Caso contrário, o vendedor rejeita a compra e o jogador precisa conseguir mais ouro.
     * @param vendedor
     * @param heroi
     */
    public void vender(Vendedor vendedor, Heroi heroi) {
        if (Tools.validarSimNao()) {
            do {
                if (heroi.getOuro() != 0) {
                    vendedor.mostrarLoja();
                    Historia.vendedorPergunta();
                    System.out.println(Tools.color.WHITE_BRIGHT +
                            heroi.getNome() + Tools.color.GREEN_BRIGHT + " vejo que tens " + Tools.color.YELLOW_BRIGHT +
                            heroi.getOuro() + Tools.color.GREEN_BRIGHT + " 🪙. Não é mau, não é mau... " +
                            "Mas cuidado! Ouro gasto é ouro que não volta.\n");
                } else {
                    System.out.println(Tools.color.GREEN_BRIGHT + "\nHA HA HA...! Teus bolsos estão mais vazios do que meu " +
                            "estômago.\n" +
                            "Volta quando tiver 🪙. Boa sorte na tua jornada! E cuidado com os inimigos...\n");
                    Tools.pausar();
                    break;
                }
            } while (vendedor.vender(heroi));
        } else {
            Historia.vendedorDespedida();
        }
        vendedor.limparItensMostrados();
    }

    /**
     * Método para criar uma barra de vida colorida
     * @param heroi O herói envolvido na batalha.
     * @param npc   O NPC inimigo.
     */
    public static void mostrarBarraHP(Heroi heroi, NPC npc) {
        int barraLargura = 20;
        String barra = "";

        System.out.println("\n" + Tools.color.WHITE_BRIGHT + heroi.getNome() + "                         " + Tools.color.RED_BRIGHT +
                "VS"
                + Tools.color.WHITE_BRIGHT + "  " + npc.getNome());

        System.out.println("HP:" + heroi.getHp() + " " + corBarra(heroi.getHp(), heroi.getMaxHp(), barraLargura) +
                "     " + corBarra(npc.getHp(), npc.getMaxHp(), barraLargura) + Tools.color.WHITE_BRIGHT + " " + npc.getHp() + ":HP\n");

    }

    /**
     * Método auxiliar para criar barras de HP coloridas.
     * @param hp          Vida atual do personagem.
     * @param maxHp       Vida máxima do personagem.
     * @param barraLargura Tamanho da barra de HP.
     * @return Uma string representando a barra de HP colorida.
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
