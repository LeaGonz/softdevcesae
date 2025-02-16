package itens;

import Enums.Personagem;

public class ConsumivelCombate extends Consumivel {
    private int ataqueInstantaneo;

    /**
     * Construtor
     * @param nome
     * @param preco
     * @param personagem
     * @param ataqueInstantaneo
     */
    public ConsumivelCombate(String nome, int preco, Personagem personagem, int ataqueInstantaneo) {
        super(nome, preco, personagem);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    /**
     * Método para mostrar detalhes do ataque instanâneo
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("| Ataque Instantâneo: " + this.ataqueInstantaneo);
    }

    /**
     * Getters
     */
    public int getAtaqueInstantaneo() {
        return ataqueInstantaneo;
    }

    /**
     * Setters
     */
    public void setAtaqueInstantaneo(int ataqueInstantaneo) {
        this.ataqueInstantaneo = ataqueInstantaneo;
    }
}
