package entidades;

import items.ArmaPrincipal;
import items.Consumivel;

import java.util.ArrayList;

public abstract class Heroi extends Entidade {
    protected int nivel;
    protected int ouro;
    protected ArmaPrincipal armaPrincipal;
    protected ArrayList<Consumivel> inventario;

    /**
     * Construtor
     * @param nome
     * @param hp
     * @param forca
     * @param nivel
     * @param ouro
     * @param armaPrincipal
     */
    public Heroi(String nome, int hp, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal) {
        super(nome, hp, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<>();
    }

    /**
     * Método de luta entre um herói e um entidades.NPC
     * @param lutadorNpc
     */
    @Override
    public void atacar(NPC lutadorNpc) {
        System.out.println("METODO ATACA HEROI");
    }
}
