package entidades;

import Enums.Personagem;
import jogo.Historia;
import jogo.Tools;

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
        Historia.combateTurno(this);
        int ataque = this.tipoAtaque();
        if (!npc.recebeAtaque(ataque)) {
            this.subirNivel(npc);
            return false;
        }

        // Ataca o NPC
        Historia.combateTurno(npc);
        ataque = (int) Math.round((npc.getForca() + (npc.getForca() * 0.1)));
        if (!this.recebeAtaque(ataque)) return false;

        Tools.pausar();

        return true;
    }
}

