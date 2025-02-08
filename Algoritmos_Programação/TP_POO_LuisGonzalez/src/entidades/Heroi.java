package entidades;

import Enums.Personagem;
import itens.ArmaPrincipal;
import itens.Consumivel;

import java.util.ArrayList;

public abstract class Heroi extends Entidade {
    private int nivel;
    private int ouro;
    private ArmaPrincipal armaPrincipal;
    private ArrayList<Consumivel> inventario;

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
    public Heroi(Personagem nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.inventario = new ArrayList<>();
    }

    /**
     * Método atacar dum herói a um NPC
     *
     * @param lutadorNpc
     * @return
     */
    public abstract boolean atacar(NPC npc);

    /**
     * Método listar e usar poções dum herói
     */
    public void usarPocao(){

    }

    /**
     * Getters
     */
    public int getNivel() {
        return nivel;
    }

    public int getOuro() {
        return ouro;
    }

    public ArmaPrincipal getArmaPrincipal() {
        return armaPrincipal;
    }

    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }


}
