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

    public boolean ataqueNPC(Heroi heroi, int ataque) {
        heroi.recebeAtaque(ataque);
        System.out.println(this.getNome() + " ataca e causa " + ataque + " de dano!");

        // Verificar vida do herói
        if (!heroi.vivo()) {
            System.out.println(heroi.getNome() + " ha perdido");
            return false;
        }
        return true;
    }

    /**
     * Getters
     */
    public int getOuro() {
        return ouro;
    }
}
