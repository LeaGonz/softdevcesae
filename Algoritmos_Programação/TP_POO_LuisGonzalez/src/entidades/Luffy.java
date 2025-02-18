package entidades;

import Enums.Personagem;
import jogo.Historia;
import jogo.Tools;

public class Luffy extends Heroi {
    private boolean gear5;

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
        Historia.combateTurno(npc);
        int ataque = (int) (npc.getForca() * 0.8);
        if (!this.recebeAtaque(ataque)) return false;

        // Ataca o Herói
        Historia.combateTurno(this);

        // GEAR 5 VS KAIDO
        if(this.getHp() <= (this.getMaxHp()*0.20) && npc.getNome().equals("Kaido")){
            if (!this.)
        }

        ataque = this.tipoAtaque();
        if (!npc.recebeAtaque(ataque)) {
            this.subirNivel(npc);
            return false;
        }
        Tools.pausar();
        return true;
    }

    public boolean isGear5() {
        return gear5;
    }

    public void setGear5(boolean gear5) {
        this.gear5 = gear5;
    }
}