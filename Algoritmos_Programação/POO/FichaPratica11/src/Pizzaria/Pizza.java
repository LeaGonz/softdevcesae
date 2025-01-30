package Pizzaria;

import Pizzaria.Enums.Tamanho;

import java.util.ArrayList;

public class Pizza {
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private Tamanho tamanho;
    private ArrayList<IngredientePizza> ingredientes;

    public Pizza(String codigo, String nome, String descricao, double preco, Tamanho tamanho) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.ingredientes = new ArrayList<>();
    }

    public void adicionarIngrediente(IngredientePizza ingrediente) {
        if (this.ingredientes.size() <= 5) {
            this.ingredientes.add(ingrediente);
            System.out.println(this.ingredientes.getLast().getNome() + " adicionado com sucesso a Pizza " + this.nome);
        } else {
            System.out.println("Não é possível adicionar mais ingredientes a Pizza " + this.nome);
        }
    }
}
