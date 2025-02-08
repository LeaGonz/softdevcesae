package jogo;

import entidades.Heroi;

public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        // INTRO
        Historia.intro();
        Jogo.pausar();

        // Escolha de Personagem
        Historia.escolhaPersonagem();
        Jogo.pausar();
        Heroi jogador = jogo.criarPersonagem();

        jogo.onePieceWano(jogador);
    }
}
