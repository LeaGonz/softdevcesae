package Ex03;

import java.util.ArrayList;

public class BarcoPesca {
    private String nome, cor, anoFabrico;
    private int tripulacao;
    private double capacidadeCarga;
    private Marca marca;
    private ArrayList<Peixe> peixesPescados = new ArrayList<>();
    private ArrayList<Marisco> mariscoPescados = new ArrayList<>();

    // construtor


    public BarcoPesca(String nome, String cor, String anoFabrico, int tripulacao, double capacidadeCarga, Marca marca) {
        this.nome = nome;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.tripulacao = tripulacao;
        this.capacidadeCarga = capacidadeCarga;
        this.marca = marca;
    }

    // Metodos instancias
    public void pescarPeixe(Peixe peixe) {
        if (this.capacidadeCarga >= peixe.getPeso()) {
            this.peixesPescados.add(peixe);
            this.capacidadeCarga -= peixe.getPeso();
            System.out.println("Espécie (" + peixe.getEspecie() + ") con peso " +
                    peixe.getPeso() + "cargada com sucesso!\nCarga disponivel do barco: " +
                    this.capacidadeCarga);
        } else {
            System.out.println("O barco não tem capacidade para a carga: " +
                    peixe.getEspecie() + " | " + peixe.getPeso() + " |\n" +
                    "Capacidade atual: " + this.capacidadeCarga);
        }
    }

    public void pescarMarisco(Marisco marisco) {
        if (this.capacidadeCarga >= marisco.getPeso()) {
            this.mariscoPescados.add(marisco);
            this.capacidadeCarga -= marisco.getPeso();
            System.out.println("Espécie (" + marisco.getEspecie() + ") con peso " +
                    marisco.getPeso() + "cargada com sucesso!\nCarga disponivel do barco: " +
                    this.capacidadeCarga);
        } else {
            System.out.println("O barco não tem capacidade para a carga: " +
                    marisco.getEspecie() + " | " + marisco.getPeso() + " |\n" +
                    "Capacidade atual: " + this.capacidadeCarga);
        }
    }
}
