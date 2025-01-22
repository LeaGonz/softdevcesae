package Ex03;

import java.util.ArrayList;

public class BarcoPesca {
    private String nome, cor;
    private int anoFabrico, tripulacao;
    private double capacidadeCarga;
    private Marca marca;
    private ArrayList<Peixe> peixesPescados;
    private ArrayList<Marisco> mariscoPescados;

    /**
     * Metodo construtor Barco de pesca
     *
     * @param nome
     * @param cor
     * @param anoFabrico
     * @param tripulacao
     * @param capacidadeCarga
     * @param marca
     */
    public BarcoPesca(String nome, String cor, int anoFabrico, int tripulacao, double capacidadeCarga, Marca marca) {
        this.nome = nome;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.tripulacao = tripulacao;
        this.capacidadeCarga = capacidadeCarga;
        this.marca = marca;
        this.peixesPescados = new ArrayList<>();
        this.mariscoPescados = new ArrayList<>();
    }

    /**
     * Metodo para inserir peixes ao barco
     * @param peixe
     */
    public void pescar(Peixe peixe) {
        if ((peixe.getPeso() + getCargaAtual()) <= this.capacidadeCarga) {
            this.peixesPescados.add(peixe);
        } else {
            System.out.println("O barco não tem capacidade para a carga: " +
                    peixe.getEspecie() + " | " + peixe.getPeso() + " |\n" +
                    "Capacidade atual: " + getCargaAtual());
        }
    }

    /**
     * Metodo para inserir mariscos ao barco
     * @param marisco
     */
    public void pescar(Marisco marisco) {
        if ((marisco.getPeso() + getCargaAtual()) <= this.capacidadeCarga) {
            this.mariscoPescados.add(marisco);
        } else {
            System.out.println("O barco não tem capacidade para a carga: " +
                    marisco.getEspecie() + " | " + marisco.getPeso() + " |\n" +
                    "Capacidade atual: " + getCargaAtual());
        }
    }

    /**
     * Metodo para calcular carga atual do barco
     * @return carga atual em double
     */
    public double getCargaAtual() {
        double cargaAtual = 0;
        for (Peixe peixe : this.peixesPescados) {
            cargaAtual += peixe.getPeso();
        }
        for (Marisco marisco : this.mariscoPescados) {
            cargaAtual += marisco.getPeso();
        }
        return cargaAtual;
    }


    /**
     * Metodo para largar os peixes do arraylist
     * Ao mesmo tempo, atualizamos a capacidade de carga
     *
     * @param peixe
     */
    public void largarPeixe(Peixe peixe) {
        this.capacidadeCarga += this.peixesPescados.get(peixesPescados.indexOf(peixe)).getPeso();
        this.peixesPescados.remove(peixe);
    }

    /**
     * Metodo para largar os mariscos do barco
     * Atualizamos a capacidade de carga
     *
     * @param marisco
     */
    public void largarMarisco(Marisco marisco) {
        this.capacidadeCarga += this.mariscoPescados.get(mariscoPescados.indexOf(marisco)).getPeso();
        this.mariscoPescados.remove(marisco);
    }

    public double calcularTotal() {
        double total = 0;
        for (Marisco marisco : mariscoPescados) {
            total += marisco.getPrecoKg() * marisco.getPeso();
        }
        for (Peixe peixe : peixesPescados) {
            total += peixe.getPrecoKg() * peixe.getPeso();
        }
        return total;
    }

    public void salarioTripulacao() {
        double total = calcularTotal();
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


    // CODIGO ANTIGO
//    /**
//     //     * Metodo para inserir peixes no arraylist
//     //     * @param peixe
//     //     */
//    public void pescarPeixe(Peixe peixe) {
//        if (this.capacidadeCarga >= peixe.getPeso()) {
//            this.peixesPescados.add(peixe);
//            this.capacidadeCarga -= peixe.getPeso();
//            System.out.println("Espécie (" + peixe.getEspecie() + ") con peso " +
//                    peixe.getPeso() + " cargada com sucesso!\nCarga disponivel do barco: " +
//                    this.capacidadeCarga);
//        } else {
//            System.out.println("O barco não tem capacidade para a carga: " +
//                    peixe.getEspecie() + " | " + peixe.getPeso() + " |\n" +
//                    "Capacidade atual: " + this.capacidadeCarga);
//        }
//    }
//
//    /**
//     * Metodo para inserir mariscos no arraylist
//     * @param marisco
//     */
//    public void pescarMarisco(Marisco marisco) {
//        if (this.capacidadeCarga >= marisco.getPeso()) {
//            this.mariscoPescados.add(marisco);
//            this.capacidadeCarga -= marisco.getPeso();
//            System.out.println("Espécie (" + marisco.getEspecie() + ") con peso " +
//                    marisco.getPeso() + " cargada com sucesso!\nCarga disponivel do barco: " +
//                    this.capacidadeCarga);
//        } else {
//            System.out.println("O barco não tem capacidade para a carga: " +
//                    marisco.getEspecie() + " | " + marisco.getPeso() + " |\n" +
//                    "Capacidade atual: " + this.capacidadeCarga);
//        }
//    }
}
