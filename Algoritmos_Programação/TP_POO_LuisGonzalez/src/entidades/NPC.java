package entidades;

public class NPC extends Entidade {
    protected int ouro;

    /**
     * Construtor
     * @param nome
     * @param hp
     * @param forca
     * @param ouro que pode receber um herói se ganhar a luta
     */
    public NPC(String nome, int hp, int forca, int ouro) {
        super(nome, hp, forca);
        this.ouro = ouro;
    }

    /**
     * Método de luta (FALTA REVISARLO)
     * @param lutadorNpc
     */
    @Override
    public void atacar(NPC lutadorNpc) {

    }
}
