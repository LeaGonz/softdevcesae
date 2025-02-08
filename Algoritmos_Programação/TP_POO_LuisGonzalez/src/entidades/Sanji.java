package entidades;

import Enums.Personagem;

public class Sanji extends Heroi {

    public Sanji(Personagem nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca, nivel, ouro);
    }

    /**
     * Método de luta entre Sanji e um entidades. NPC
     *
     * @param lutadorNpc
     * @return
     */
    @Override
    public boolean atacar(NPC lutadorNpc) {

        return false;
    }
}
