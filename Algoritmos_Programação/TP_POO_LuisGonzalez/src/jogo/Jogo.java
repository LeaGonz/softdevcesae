package jogo;


import entidades.Heroi;
import entidades.Luffy;
import items.ArmaPrincipal;

public class Jogo {

    /**
     * Método onde será explicado o jogo
     */
    public void intro(){
        System.out.println("Intro do jogo, explicacao, etc....");
    }

    /**
     * Método para criar uma personagem
     */
    public Heroi criarPersonagem(){
        System.out.println("Escolha um personagem para iniciar o jogo:\n1- Luffy\n2- Zoro\n3- Sanji");

        Luffy luffy = new Luffy("Monkey D. Luffy",100,100,1,10,ArmaPrincipal)

        return luffy;
    }

    /**
     * Método principal do jogo e recebe um herói
     */
    public void onePieceWano(){

    }
}
