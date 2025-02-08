package entidades;

import Enums.Personagem;

public class Zoro extends Heroi {

    public Zoro(Personagem nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca, nivel, ouro);
    }

    /**
     * Método de luta entre Zoro e um entidades. NPC
     *
     * @param lutadorNpc
     * @return
     */
    @Override
    public boolean atacar(NPC lutadorNpc) {

        return false;
    }
}
