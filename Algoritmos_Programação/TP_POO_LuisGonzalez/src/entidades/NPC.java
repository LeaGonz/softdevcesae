package entidades;

import Enums.Personagem;

import java.util.ArrayList;
import java.util.Random;

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
