package items;

public class ConsumivelCombate extends Consumivel {
    protected int ataqueInstantaneo;

    /**
     * Construtor
     * @param nome
     * @param preco
     * @param ataqueInstantaneo
     */
    public ConsumivelCombate(String nome, int preco, int ataqueInstantaneo) {
        super(nome, preco);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    /**
     * Método para mostrar detalhes do ataque instanâneo
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Ataque Instantâneo: " + this.ataqueInstantaneo);
    }
}
