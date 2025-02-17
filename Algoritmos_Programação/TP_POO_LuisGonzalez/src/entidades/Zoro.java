package entidades;

import Enums.Personagem;
import jogo.Historia;
import jogo.Tools;

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
    public boolean atacar(NPC npc) {
        // Ataca o Herói
        Historia.combateTurno(this);
        int ataque = this.tipoAtaque();
        if (!npc.recebeAtaque(ataque)) {
            this.subirNivel(npc);
            return false;
        }

        Tools.pausar();

        // Ataca o NPC
        Historia.combateTurno(npc);
        return this.recebeAtaque(npc.getForca());
    }
}
