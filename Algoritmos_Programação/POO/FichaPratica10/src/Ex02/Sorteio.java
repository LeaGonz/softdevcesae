package Ex02;

import java.util.ArrayList;
import java.util.Random;

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
        else System.out.println("O participante " + participante.getNome() +
                " não é maior de idade");
    }

    public Pessoa sortear() {
        Random random = new Random();
        int ganhador = random.nextInt(this.listaParticipantes.size());
        return this.listaParticipantes.get(ganhador);
    }

    public void mostrarParticipantes() {
        for (int i = 0; i < this.listaParticipantes.size(); i++) {
            System.out.println("Participante " + (i + 1) + ": " +
                    this.listaParticipantes.get(i).getNome() + " | " +
                    this.listaParticipantes.get(i).getIdade() + " | " +
                    this.listaParticipantes.get(i).getTelemovel() + " | " +
                    this.listaParticipantes.get(i).getEmail());
        }
    }
}
