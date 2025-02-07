package entidades;

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
    public Luffy(String nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca, nivel, ouro);
    }

    /**
     * Método de luta entre Luffy e um entidades.NPC
     * @param lutadorNpc
     */
    @Override
    public void atacar(NPC lutadorNpc) {
    }
}
