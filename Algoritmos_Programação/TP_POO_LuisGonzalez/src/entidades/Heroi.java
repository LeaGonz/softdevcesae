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
     *
     * @param nome
     * @param hp
     * @param forca
     * @param nivel
     * @param ouro
     * @param armaPrincipal
     */
    public Heroi(String nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.inventario = new ArrayList<>();
    }

    /**
     * Método atacar dum herói a um NPC
     * @param lutadorNpc
     */
    public abstract void atacar(NPC lutadorNpc);

    /**
     * Método listar e usar poções dum herói
     */
    public void usarPocao(){

    }
}
