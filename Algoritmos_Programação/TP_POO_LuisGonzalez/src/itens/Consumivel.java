package itens;

import Enums.Personagem;

public abstract class Consumivel extends ItemHeroi {

    /**
     * Construtor
     * @param nome
     * @param preco
     * @param personagem
     */
    public Consumivel(String nome, int preco, Personagem personagem) {
        super(nome, preco);
        super.getHeroisPermitidos().add(personagem);

    }
}
