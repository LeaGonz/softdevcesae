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
    private static Random rnd = new Random();

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

        // 1 VILA KOSUKI
        vilaKosuki(heroi, vendedor);

        // 2 VILA LAMENTOS
        vilaLamentos(heroi, vendedor);

        // 3 VILA HAKUMAI
        vilaHakumai(heroi, vendedor);

        // 4 VILA AMIGASA
        vilaAmigasa(heroi, vendedor);

        // 5 VILA RENGOKU
        vilaRengoku(heroi, vendedor);

        // 6 KAIDO ONIGASHIMA
        onigashima(heroi, vendedor);
    }


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
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
        } while (true);
    }

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
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }

        } while (true);
    }

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
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }

        } while (true);
    }

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
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
        } while (true);
    }

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
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
        } while (true);
    }

    private boolean onigashima(Heroi heroi, Vendedor vendedor) {
        //HISTORIA
        Historia.kaidoChegada();

        Historia.kaidoIntro();
        Historia.kaidoOnigashima();

        /***************** MISSÃO SANJI *****************/
        boolean sanji = true;

        // MUDAMOS HERÓI E ITENS (SE HOUVER)
        heroi.mudarHeroi(Personagem.Sanji);
        Historia.kaidoSanji();
        heroi.mostrarDetalhes();

        do {
            //ESCOLHER CAMINHO
            Historia.kaidoSanjiEscolha();
            int caminho = Tools.validarEscolhaNum(1, 3);
            switch (caminho) {
                case 1: // INIMIGO
                    sanji = combate(heroi);
                    if (sanji) return sanji;
                    break;
                case 2: // VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 3: // POÇÕES
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
        heroi.mudarHeroi(Personagem.Zoro);
        Historia.kaidoZoro();
        heroi.mostrarDetalhes();

        do {
            //ESCOLHER CAMINHO
            Historia.kaidoZoroEscolha();
            int caminho = Tools.validarEscolhaNum(1, 3);
            switch (caminho) {
                case 1: // INIMIGO
                    zoro = combate(heroi);
                    if (zoro) return zoro;
                    break;
                case 2: // VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 3: // POÇÕES
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
        } while (zoro);

        /***************** BATALHA FINAL LUFFY VS KAIDO *****************/
        // MUDAMOS HERÓI E ITENS (SE HOUVER)
        heroi.mudarHeroi(Personagem.Luffy);
        Historia.kaidoLuffy();
        heroi.mostrarDetalhes();

        do {
            //ESCOLHER CAMINHO
            Historia.kaidoLuffyEscolha();
            int caminho = Tools.validarEscolhaNum(1, 3);
            switch (caminho) {
                case 1: // INIMIGO
                    return combate(heroi);
                case 2: // VENDEDOR
                    vilaVender(vendedor, heroi);
                    break;
                case 3: // POÇÕES
                    heroi.usarPocao();
                    break;
                default:
                    System.out.println("👹 CAMINHO INCORRETO 👹");
                    break;
            }
        } while (true);
    }


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
     * Método combate entre Herói e NPC
     * Retorna FALSE se ganha o HERÓI
     * Retorna TRUE se ganha o NPC
     *
     * @param heroi
     */
    public boolean combate(Heroi heroi) {
        // Criamos NPC para o combate
        NPC npc = criarNPC();

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
        vendedor.adicionarItem(new ArmaPrincipal("Diable Jambe Boots 🔥", 10, 10, 100, Personagem.Sanji));
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
     * Método para criar uma barra de vida que muda de cor
     *
     * @param heroi
     * @param npc
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
