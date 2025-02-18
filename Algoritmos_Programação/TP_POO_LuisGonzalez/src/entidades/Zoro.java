package entidades;

import Enums.Personagem;
import jogo.Historia;
import jogo.Tools;

/**
 * Classe que representa o personagem Zoro no jogo. Implementa
 * o método de combate específico para Zoro
 */
public class Zoro extends Heroi {

    public Zoro(Personagem nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca, nivel, ouro);
    }

    /**
     * Método que realiza a luta entre Zoro e um NPC inimigo.
     * Zoro ataca o NPC e, em seguida, o NPC revida o ataque.
     *
     * @param npc inimigo
     * @return Retorna {@code false} se Zoro vencer o combate e o NPC for derrotado,
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
        if (!this.recebeAtaque(npc.getForca())) return false;

        Tools.pausar();

        return true;
    }
}
