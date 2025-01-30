package Pizzaria;

import Pizzaria.Enums.Unidade;

public class Ingrediente {
    private String codigo;
    private String nome;
    private Unidade unidadeMedida;
    private double calorias;

    public Ingrediente(String codigo, String nome, Unidade unidadeMedida, double calorias) {
        this.codigo = codigo;
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.calorias = calorias;
    }

    // Getters
    public String getNome() {
        return nome;
    }
}
