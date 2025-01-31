package Pizzaria;

import Pizzaria.Enums.Tamanho;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class Pizza {
    private final int MAX_INGREDIENTES = 5;
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private Tamanho tamanho;
    private ArrayList<IngredientePizza> ingredientes;
    static Scanner in = new Scanner(System.in);

    public Pizza(String codigo, String nome, String descricao, double preco, Tamanho tamanho) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.ingredientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    /**
     * Metodo para adicionar max 5 ingredientes por pizza
     *
     * @param ingrediente
     */
    public void adicionarIngrediente(IngredientePizza ingrediente) {
        if (this.ingredientes.size() < MAX_INGREDIENTES) {
            this.ingredientes.add(ingrediente);
            System.out.println("*" + this.ingredientes.getLast().getIngrediente().getNome() + "* adicionado com " +
                    "sucesso a |" + this.nome + "|");
        } else {
            System.out.println("Não é possível adicionar mais ingredientes a |" + this.nome + "|");
        }
    }

    /**
     * Metodo para editar a quantidade de um ingrediente
     */
    public void editarQuantidade() {
        System.out.println("************* " + this.nome + " ************* ");
        listarIngredientes();

        System.out.println("Qual ingrediente deseja editar?");
        int op = in.nextInt();
        in = new Scanner(System.in);

        System.out.print("Nova quantidade de *" + this.ingredientes.get(op - 1).getIngrediente().getNome() + "* : ");
        double quantidade = in.nextDouble();

        this.ingredientes.get(op - 1).setQuantidade(quantidade);
        System.out.println("*" + this.ingredientes.get(op - 1).getIngrediente().getNome() + "* editado com sucesso");
        listarIngredientes();
    }

    /**
     * Metodo para remover ingredientes duma pizza
     */
    public void removerIngrediente() {
        System.out.println("************* " + this.nome + " ************* ");
        listarIngredientes();

        System.out.println("Qual ingrediente deseja remover?");
        String op = in.nextLine().toUpperCase();

//        System.out.println("*" + this.ingredientes.get().getIngrediente().getNome() + "* removido com sucesso");
        for(IngredientePizza ingrediente : this.ingredientes) {
            if(ingrediente.getIngrediente().getCodigo().equals(op)) {
                this.ingredientes.remove(ingrediente);
                listarIngredientes();
                return;
            }
        }
    }

    public double caloriasTotal() {
        double total = 0;
        for (int i = 0; i < this.ingredientes.size(); i++) {
            total += (this.ingredientes.get(i).getIngrediente().getCalorias() * this.ingredientes.get(i).getQuantidade());
        }
        return total;
    }

    /**
     * Metodo para listar todos os ingredientes duma pizza
     */
    public void listarIngredientes() {
        for (int i = 0; i < this.ingredientes.size(); i++) {
            System.out.println(i + 1 + " | " + this.ingredientes.get(i).getIngrediente().getNome() + " | " + this.ingredientes.get(i).getQuantidade() + " | "+this.ingredientes.get(i).getIngrediente().getCodigo());
        }
    }
}
