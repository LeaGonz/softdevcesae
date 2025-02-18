package itens;

import Enums.Personagem;
import jogo.Tools;

import java.util.ArrayList;

/**
 * Classe abstrata que representa um item utilizado por heróis no jogo.
 * Itens podem ser armas, consumíveis ou outros tipos de objetos que afetam o herói.
 */
public abstract class ItemHeroi {
    private String nome;
    private int preco;
    private ArrayList<Personagem> heroisPermitidos;

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
     * Método que exibe os detalhes do item, incluindo nome, preço e os heróis que podem utilizá-lo.
     */
    public void mostrarDetalhes() {
        System.out.printf("%-30s | %-6d | %-10s ", this.nome, this.preco, this.heroisPermitidos);
    }

    /**
     * Getters
     */
    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return this.preco;
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
