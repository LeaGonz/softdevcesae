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
        int ataque = this.tipoAtaque();
        npc.recebeAtaque(ataque);
        System.out.println(this.getNome() + " ataca e causa " + ataque + " de dano!");

        // Verificar HP do NPC
        if (!npc.vivo()) {
            System.out.println(npc.getNome() + " ha perdido");
            npc = null;
            return false;
        }

        // Ataca o NPC
        ataque = (int) Math.round((npc.getForca() + (npc.getForca() * 0.1)));
        this.recebeAtaque(ataque);
        System.out.println(npc.getNome() + " ataca e causa " + ataque + " de dano!");

        // Verificar HP do herói
        if (!this.vivo()) {
            System.out.println(this.getNome() + " ha perdido");
            return false;
        }
        return true;
    }
}

