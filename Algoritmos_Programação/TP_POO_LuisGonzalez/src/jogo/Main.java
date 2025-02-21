package jogo;

import Enums.Personagem;
import entidades.*;

/**
 * Classe principal que inicia o jogo. Aqui o jogador pode criar um personagem,
 * jogar a história do arco de Wano, e decidir o que fazer após perder o jogo,
 * seja continuar com o mesmo herói, criar um novo herói ou sair do jogo.
 */
public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        // INTRO
        Historia.logoIntro();
        Historia.intro();

        // Escolha de Personagem
        Heroi jogador = jogo.criarPersonagem();

        // Creamos o jogador de respaldo para voltar a jogar com o mesmo
        Heroi respaldo = getHeroiRespaldo(jogador);

        // ciclo principal de jogo
        if (jogo.onePieceWano(jogador)) {
            while (true) {
                Historia.perdioJogo();
                System.out.printf(Tools.color.WHITE_BRIGHT + """
                                O que deseja fazer agora?
                                
                                %s1-%s Tentar novamente com o mesmo Herói.
                                %s2-%s Criar un novo Herói.
                                %s3-%s Sair do jogo.
                                
                                """, Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                        Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                        Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);

                int escolhaJogo = Tools.validarEscolhaNum(1, 3);

                switch (escolhaJogo) {
                    case 1:
                        System.out.printf(Tools.color.WHITE_BRIGHT + """
                                
                                ⛩️ "Não importa quantas vezes eu caia… eu sempre vou me levantar!"
                                
                                "Porque eu sou %sMonkey D. Luffy…%s"
                                
                                "E eu vou derrotar Kaido!!!" ⛩️
                                
                                """, Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);
                        // igualamos jogador ao respaldo
                        jogador = getHeroiRespaldo(respaldo);
                        jogo.onePieceWano(jogador);
                        break;
                    case 2:
                        System.out.printf(Tools.color.WHITE_BRIGHT + """
                                
                                ⛩️ "%sSe vais começar de novo%s, então fica mais forte do que nunca!"
                                
                                "Levanta-te, segue em frente... e luta como um verdadeiro guerreiro!" ⛩️
                                
                                """, Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);
                        jogador = jogo.criarPersonagem();
                        jogo.onePieceWano(jogador);
                        break;
                    case 3:
                        System.out.printf(Tools.color.WHITE_BRIGHT + """
                                
                                ⛩️ "Então é assim que termina...?"
                                
                                "Ainda há batalhas a serem lutadas, ainda há amigos a serem protegidos..."
                                
                                "Mas se essa é a tua escolha… então um dia, %sespero te ver navegando de novo!%s" ⛩️
                                
                                """, Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);
                        Tools.stopAudio();
                        return;
                    default:
                        System.out.println("👹 Escolha inválida. Tente novamente. 👹");
                }
            }
        }
    }

    /**
     * Método para criar um jogador de respaldo, ou seja, um novo herói com as mesmas propriedades
     * (vida, força, nível e ouro) do herói atual.
     *
     * @param jogador O herói atual do jogador.
     * @return O herói de respaldo, que tem os mesmos atributos do jogador.
     */
    private static Heroi getHeroiRespaldo(Heroi jogador) {
        Heroi respaldo = null;
        if (jogador instanceof Luffy)
            respaldo = new Luffy(Personagem.Luffy, jogador.getHp(), jogador.getForca(), jogador.getNivel(), jogador.getOuro());

        if (jogador instanceof Zoro)
            respaldo = new Zoro(Personagem.Zoro, jogador.getHp(), jogador.getForca(), jogador.getNivel(), jogador.getOuro());

        if (jogador instanceof Sanji)
            respaldo = new Sanji(Personagem.Sanji, jogador.getHp(), jogador.getForca(), jogador.getNivel(), jogador.getOuro());
        return respaldo;
    }
}

