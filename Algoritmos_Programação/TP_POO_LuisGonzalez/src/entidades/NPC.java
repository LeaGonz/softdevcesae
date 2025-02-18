package entidades;

import Enums.Personagem;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe que representa um NPC no jogo. e é responsável por
 * gerar NPCs com características aleatórias, como nome, vida (hp), força e a quantidade de ouro que o NPC possui.
 */
public class NPC extends Entidade {
    private int ouro;

    /**
     * Construtor
     *
     * @param nome
     * @param hp
     * @param forca
     * @param ouro  que pode receber um herói se ganhar a luta
     */
    public NPC(Personagem nome, int hp, int forca, int ouro) {
        super(nome, hp, forca);
        this.ouro = ouro;
    }

    /**
     * Método para criar um NPC aleatório baseado nas características do herói.
     * O NPC gerado terá um nome aleatório, com vida (hp) e força baseados nas propriedades do herói.
     *
     * @param heroi O herói com o qual o NPC será comparado para gerar suas características.
     * @return Um NPC com características aleatórias baseadas no herói.
     */
    public static NPC criarNPC(Heroi heroi) {
        Random rnd = new Random();
        // Listagem de nomes random
        ArrayList<Personagem> nomesNpc = new ArrayList<>();
        nomesNpc.add(Personagem.Jack);
        nomesNpc.add(Personagem.Kurozumi);
        nomesNpc.add(Personagem.Sasaki);
        nomesNpc.add(Personagem.Who);
        nomesNpc.add(Personagem.Ulti);
        int nome = rnd.nextInt(nomesNpc.size());

        // Geramos HP e Força do NPC entre 80% e 120% dos valores do herói
        int hp = (int) (heroi.getMaxHp() * (0.8 + (0.4 * rnd.nextDouble())));
        int forca = (int) (heroi.getForca() * (0.8 + (0.4 * rnd.nextDouble())));
        int ouro = rnd.nextInt(10, 20);

        return new NPC(nomesNpc.get(nome), hp, forca, ouro);
    }

    /**
     * Método para criar um NPC com características específicas de um personagem BOSS FINAL.
     * O NPC gerado terá vida (hp) e força entre 80% e 160% dos valores do herói,
     * com o nome e características do NPC especificado.
     *
     * @param heroi O herói com o qual o NPC será comparado para gerar suas características.
     * @param npc O nome do NPC a ser criado.
     * @return Um NPC com as características do herói e o nome do NPC fornecido.
     */
    public static NPC criarNPC(Heroi heroi, Personagem npc) {
        Random rnd = new Random();

        // Geramos HP e Força do NPC entre 80% e 160% dos valores do herói
        int hp = (int) (heroi.getMaxHp() * (0.8 + (0.8 * rnd.nextDouble())));
        int forca = (int) (heroi.getForca() * (0.8 + (0.8 * rnd.nextDouble())));
        int ouro = rnd.nextInt(10, 20);

        return new NPC(npc, hp, forca, ouro);
    }

    /**
     * Getters
     */
    public int getOuro() {
        return ouro;
    }
}
