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
        this.recebeAtaque(ataque);
        System.out.println(npc.getNome() + " ataca e causa " + ataque + " de dano!");

        // Verificar HP do herói
        if (!this.vivo()) {
            System.out.println(this.getNome() + " ha perdido");
            return false;
        }

        // Ataca o Herói
        ataque = this.tipoAtaque();
        npc.recebeAtaque(ataque);
        System.out.println(this.getNome() + " ataca e causa " + ataque + " de dano!");

        // Verificar HP do NPC
        if (!npc.vivo()) {
            // Adicionamos ouro ao herói
            this.ouroHeroi(npc.getOuro());
            System.out.println(npc.getNome() + " ha perdido");
            // Apagamos o NPC
            npc = null;
            return false;
        }

        return true;
    }
}
