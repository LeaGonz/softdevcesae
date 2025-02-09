package itens;

import Enums.Personagem;

import java.util.ArrayList;

public abstract class ItemHeroi {
    protected String nome;
    protected int preco;
    protected ArrayList<Personagem> heroisPermitidos;

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
        System.out.printf("Nome: %-30s | Preço: %-5d | Herói:%s%n", this.nome, this.preco, this.heroisPermitidos);
    }

    /**
     * Getters
     */
    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public ArrayList<Personagem> getHeroisPermitidos() {
        return heroisPermitidos;
    }

    /**
     * Setters
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setHeroisPermitidos(ArrayList<Personagem> heroisPermitidos) {
        this.heroisPermitidos = heroisPermitidos;
    }
}
