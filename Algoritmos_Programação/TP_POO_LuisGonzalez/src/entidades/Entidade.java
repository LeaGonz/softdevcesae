package entidades;

public abstract class Entidade {
    protected String nome;
    protected int maxHp;
    protected int hp;
    protected int forca;

    /**
     * Construtor
     *
     * @param nome
     * @param hp    vida da entidades.Entidade. maxHp vai ser igual a hp
     * @param forca
     */
    public Entidade(String nome, int hp, int forca) {
        this.nome = nome;
        this.hp = hp;
        this.maxHp = hp;
        this.forca = forca;
    }

    /**
     * Método mostrar detalhes da entidades.Entidade
     */
    public void mostrarDetalhes() {
        System.out.printf("Nome: %-10s | Força: %-10d%n", this.nome, this.forca);
        System.out.printf("HP: %-10d | HP máximo: %-10d%n", this.hp, this.maxHp);
    }

}
