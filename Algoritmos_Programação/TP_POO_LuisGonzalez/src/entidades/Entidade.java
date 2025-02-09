package entidades;

import Enums.Personagem;

public abstract class Entidade {
    private Personagem nome;
    private int maxHp;
    private int hp;
    private int forca;

    /**
     * Construtor
     *
     * @param nome
     * @param hp    vida da entidades.Entidade. maxHp vai ser igual a hp
     * @param forca
     */
    public Entidade(Personagem nome, int hp, int forca) {
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

    /**
     * Método para subtrair o dano dum ataque
     *
     * @param dano
     */
    public void recebeAtaque(int dano) {
        this.hp -= dano;
        if (this.hp < 0) this.hp = 0;
    }

    public boolean atacaNpc(Heroi heroi, int ataque) {
        heroi.recebeAtaque(ataque);
        System.out.println(this.getNome() + " ataca e causa " + ataque + " de dano!");

        // Verificar HP do herói
        if (!this.vivo()) {
            System.out.println(heroi.getNome() + " ha perdido");
            return false;
        }
        return true;
    }

    /**
     * Método para verificar se a Entidade continua viva
     *
     * @return
     */
    public boolean vivo() {
        return this.hp > 0;
    }

    /**
     * Getters
     */
    public Personagem getNome() {
        return nome;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getForca() {
        return forca;
    }
}
