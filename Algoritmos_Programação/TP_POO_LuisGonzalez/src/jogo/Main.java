package jogo;

import entidades.Heroi;

public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        // TESTEEEEEESSSSSSSSSSSSSS

        // TESTEEEEEESSSSSSSSSSSSSS

        // INTRO
        Historia.logoIntro();
        Historia.intro();

        // Escolha de Personagem
        Heroi jogador = jogo.criarPersonagem();

        jogo.onePieceWano(jogador);
    }
}

