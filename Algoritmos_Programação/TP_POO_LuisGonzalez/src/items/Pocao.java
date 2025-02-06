package items;

public class Pocao extends Consumivel{
    protected int vidaCurar;
    protected int aumentoForca;

    /**
     * Construtor
     * @param nome
     * @param preco
     * @param vidaCurar
     * @param aumentoForca
     */
    public Pocao(String nome, int preco, int vidaCurar, int aumentoForca) {
        super(nome, preco);
        this.vidaCurar = vidaCurar;
        this.aumentoForca = aumentoForca;
    }

    /**
     * Método para mostrar os detalhes da poção
     */
    @Override
    public void mostrarDetalhes() {
        System.out.printf("Vida a curar: %-10d | Aumento de Força: %-10d%n", this.vidaCurar, this.aumentoForca);
    }
}
