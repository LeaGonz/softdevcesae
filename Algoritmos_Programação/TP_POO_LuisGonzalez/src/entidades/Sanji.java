package entidades;

import items.ArmaPrincipal;

public class Sanji extends Heroi {

    public Sanji(String nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca, nivel, ouro);
    }

    /**
     * Método de luta entre Sanji e um entidades. NPC
     * @param lutadorNpc
     */
    @Override
    public void atacar(NPC lutadorNpc) {

    }
}
