package items;

import java.util.ArrayList;

public abstract class ItemHeroi {
    protected String nome;
    protected int preco;
    protected ArrayList<String> heroisPermitidos;

    /**
     * Construtor
     *
     * @param nome
     * @param preco
     */
    public ItemHeroi(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
        this.heroisPermitidos = new ArrayList<>();
    }

    /**
     * Método mostrar detalhes do Item
     */
    public void mostrarDetalhes() {
        System.out.printf("Nome: %-10s | Preço: %-10d%n", this.nome, this.preco);
        System.out.println("Herois: " + this.heroisPermitidos);

    }
}
