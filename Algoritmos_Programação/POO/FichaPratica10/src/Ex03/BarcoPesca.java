package Ex03;

import java.util.ArrayList;

public class BarcoPesca {
    private String nome, cor, anoFabrico;
    private int tripulacao;
    private double capacidadeCarga;
    private Marca marca;
    private ArrayList<Peixe> peixesPescados = new ArrayList<>();
    private ArrayList<Marisco> mariscoPescados = new ArrayList<>();
    private double total = 0;

    // construtor


    public BarcoPesca(String nome, String cor, String anoFabrico, int tripulacao, double capacidadeCarga, Marca marca) {
        this.nome = nome;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.tripulacao = tripulacao;
        this.capacidadeCarga = capacidadeCarga;
        this.marca = marca;
    }

    /**
     * Metodo para inserir peixes no arraylist
     * @param peixe
     */
    public void pescarPeixe(Peixe peixe) {
        if (this.capacidadeCarga >= peixe.getPeso()) {
            this.peixesPescados.add(peixe);
            this.capacidadeCarga -= peixe.getPeso();
            System.out.println("Espécie (" + peixe.getEspecie() + ") con peso " +
                    peixe.getPeso() + " cargada com sucesso!\nCarga disponivel do barco: " +
                    this.capacidadeCarga);
        } else {
            System.out.println("O barco não tem capacidade para a carga: " +
                    peixe.getEspecie() + " | " + peixe.getPeso() + " |\n" +
                    "Capacidade atual: " + this.capacidadeCarga);
        }
    }

    /**
     * Metodo para inserir mariscos no arraylist
     * @param marisco
     */
    public void pescarMarisco(Marisco marisco) {
        if (this.capacidadeCarga >= marisco.getPeso()) {
            this.mariscoPescados.add(marisco);
            this.capacidadeCarga -= marisco.getPeso();
            System.out.println("Espécie (" + marisco.getEspecie() + ") con peso " +
                    marisco.getPeso() + " cargada com sucesso!\nCarga disponivel do barco: " +
                    this.capacidadeCarga);
        } else {
            System.out.println("O barco não tem capacidade para a carga: " +
                    marisco.getEspecie() + " | " + marisco.getPeso() + " |\n" +
                    "Capacidade atual: " + this.capacidadeCarga);
        }
    }

    /**
     * Metodo para largar os peixes do arraylist
     * Ao mesmo tempo, atualizamos a capacidade de carga
     * @param peixe
     */
    public void largarPeixe(Peixe peixe) {
        this.capacidadeCarga += this.peixesPescados.get(peixesPescados.indexOf(peixe)).getPeso();
        this.peixesPescados.remove(peixe.getEspecie());
    }

    /**
     * Metodo para largar os mariscos do barco
     * Atualizamos a capacidade de carga
     * @param marisco
     */
    public void largarMarisco(Marisco marisco) {
        this.capacidadeCarga += this.mariscoPescados.get(mariscoPescados.indexOf(marisco)).getPeso();
        this.mariscoPescados.remove(marisco.getEspecie());
    }

    public void calcularTotal() {
        for (Marisco marisco : mariscoPescados) {
            total += marisco.getPrecoKg() * marisco.getPeso();
        }
        for (Peixe peixe : peixesPescados) {
            total += peixe.getPrecoKg() * peixe.getPeso();
        }
        System.out.println("Total: " + total + " €");
    }

    public void salarioTripulacao() {
        if (total == 0) {
            calcularTotal();
        } else {
            double salario = (total - (total * 0.40)) / (this.tripulacao - 1);
            System.out.println(salario + "€");
        }
    }

    public void mostrarPeso() {
        System.out.println(this.capacidadeCarga);
    }
}
