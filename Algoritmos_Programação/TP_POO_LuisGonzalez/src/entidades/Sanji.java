package entidades;

import Enums.Personagem;
import jogo.Historia;
import jogo.Tools;

/**
 * Classe que representa o personagem Sanji no jogo. Implementa
 * o método de combate específico para Sanji, levando em consideração o aumento de dano devido à falta de proteção.
 */
public class Sanji extends Heroi {

    public Sanji(Personagem nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca, nivel, ouro);
    }

    /**
     * Método que realiza a luta entre Sanji e um NPC inimigo.
     * Durante o combate, Sanji recebe 10% a mais de dano devido à falta de proteção.
     * Sanji ataca o NPC, e o NPC revida o ataque.
     *
     * @param npc O NPC inimigo
     * @return Retorna {@code false} se Sanji vencer o combate e o NPC for derrotado,
     *         e {@code true} se o combate continuar.
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

