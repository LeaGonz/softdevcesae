package itens;

import Enums.Personagem;

public class ArmaPrincipal extends ItemHeroi {
    private int ataque;
    private int ataqueEspecial;

    /**
     * Construtor
     *
     * @param nome
     * @param preco          em ouro
     * @param ataque
     * @param ataqueEspecial
     * @param personagem
     */
    public ArmaPrincipal(String nome, int preco, int ataque, int ataqueEspecial, Personagem personagem) {
        super(nome, preco);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        super.getHeroisPermitidos().add(personagem);
    }

    /**
     * Detalhes do ArmaPrincipal
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.printf("| Ataque: %-16s | Ataque Especial: %-5d%n", this.ataque, this.ataqueEspecial);
    }

    /**
     * Getters
     */
    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }
}
