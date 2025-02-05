package items;

public class ArmaPrincipal extends ItemHeroi {
    protected int ataque;
    protected int ataqueEspecial;

    /**
     * Construtor
     * @param nome
     * @param preco em ouro
     * @param ataque
     * @param ataqueEspecial
     */
    public ArmaPrincipal(String nome, int preco, int ataque, int ataqueEspecial) {
        super(nome, preco);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }
}
