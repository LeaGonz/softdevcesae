package entidades;

import Enums.Personagem;
import jogo.Tools;

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

    /**
     * Método para verificar se a Entidade continua viva
     *
     * @return
     */
    public boolean vivo() {
        return this.hp > 0;
    }

    /**
     * Método de curação
     * @param pocao
     * @return true se foi recebida a poção
     */
    public boolean recebePocao(int pocao) {
        if ((this.hp + pocao) > this.maxHp) {
            System.out.println("Vai perder uma parte da cura da poção. Quer usar na mesma? (S/N)");

            if (!Tools.validarSimNao()) return false;

            this.hp += pocao;
            if (this.hp > this.maxHp) this.hp = this.maxHp;
        }
        return true;
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

    /**
     * Setters
     */
    public void setNome(Personagem nome) {
        this.nome = nome;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }
}
