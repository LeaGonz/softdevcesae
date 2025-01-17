package Ex03;

import java.sql.SQLOutput;

public class Animal {
    private String nome;
    private String especie;
    private String paisOrigem;
    private double peso;
    private String[] alimentacao;

    // Construtor

    public Animal(String nome, String especie, String paisOrigem, double peso, String[] alimentacao) {
        this.nome = nome;
        this.especie = especie;
        this.paisOrigem = paisOrigem;
        this.peso = peso;
        this.alimentacao = alimentacao;
    }

    // Metodos instancias
    public void comer(String alimento, double pesog) {
        for (String alimentos : this.alimentacao) {
            if (alimentos.equals(alimento)) {
                System.out.println("O animal comeu");
                this.peso += (pesog / 1000);
                return;
            }
        }
        System.out.println("O animal recusou essa comida");
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + this.nome + " | Especie: " + this.especie + " | Peso: " + this.peso);
    }
}
