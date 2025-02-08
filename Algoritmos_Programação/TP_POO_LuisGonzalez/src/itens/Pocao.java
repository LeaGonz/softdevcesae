package itens;

import Enums.Personagem;

public class Pocao extends Consumivel {
    protected int vidaCurar;
    protected int aumentoForca;

    /**
     * Construtor
     *
     * @param nome
     * @param preco
     * @param personagem
     * @param vidaCurar
     * @param aumentoForca
     */
    public Pocao(String nome, int preco, Personagem personagem, int vidaCurar, int aumentoForca) {
        super(nome, preco, personagem);
        this.vidaCurar = vidaCurar;
        this.aumentoForca = aumentoForca;
    }

    /**
     * Método para mostrar os detalhes da poção
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.printf("Vida a curar: %-5d | Aumento da Força: %d%n", this.vidaCurar, this.aumentoForca);
    }
}
