package entidades;

import Enums.Personagem;

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
     * Getters
     */
    public int getOuro() {
        return ouro;
    }
}
