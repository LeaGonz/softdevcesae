package entidades;

import Enums.Personagem;

public class Luffy extends Heroi {

    /**
     * Construtor
     *
     * @param nome
     * @param hp
     * @param forca
     * @param nivel
     * @param ouro
     */
    public Luffy(Personagem nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca, nivel, ouro);
    }

    /**
     * Método de luta entre Luffy e um entidades.NPC
     * O NPC ataca so com 80% da sua força
     *
     * @param npc
     * @return
     */
    @Override
    public boolean atacar(NPC npc) {
        // Ataca primeiro o NPC
        int ataque = (int) (npc.getForca() * 0.8);
        if (!npc.ataqueNPC(this, ataque)) return false;

        // Ataca o Herói
        return this.ataqueHeroi(npc);
    }
}
