package entidades;

import Enums.Personagem;

public class Sanji extends Heroi {

    public Sanji(Personagem nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca, nivel, ouro);
    }

    /**
     * Método de luta entre Sanji e um NPC
     * Herói recebe mais 10% de dano, por falta de proteção
     *
     * @param npc
     * @return
     */
    @Override
    public boolean atacar(NPC npc) {
        // Ataca o Herói
        if (!this.ataqueHeroi(npc)) return false;
        // Ataca o NPC
        int ataque = (int) Math.round((npc.getForca() + (npc.getForca() * 0.1)));
        return npc.ataqueNPC(this, ataque);
    }
}

