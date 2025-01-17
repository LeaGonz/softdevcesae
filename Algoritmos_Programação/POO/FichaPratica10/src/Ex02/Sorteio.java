package Ex02;

import java.util.ArrayList;

public class Sorteio {
    private double premio;
    private ArrayList<Pessoa> listaParticipantes = new ArrayList<>();

    // construtor

    // Metodos

    /**
     * Método que adiciona uma pessoa ao Arraylist
     *
     * @param participante
     */
    public void adicionarParticipante(Pessoa participante) {
        if (participante.getIdade() >= 18) this.listaParticipantes.add(participante);
        else System.out.println("O participante (" + participante.getNome() +
                " não é maior de idade.");
    }
}
