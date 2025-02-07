package entidades;

import items.ArmaPrincipal;

public class Zoro extends Heroi {

    public Zoro(String nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca, nivel, ouro);
    }

    /**
     * Método de luta entre Zoro e um entidades. NPC
     * @param lutadorNpc
     */
    @Override
    public void atacar(NPC lutadorNpc) {

    }
}
