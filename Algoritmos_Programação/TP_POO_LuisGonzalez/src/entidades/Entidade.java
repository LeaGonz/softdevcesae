package entidades;

import Enums.Personagem;
import jogo.Historia;
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
        System.out.printf(Tools.color.YELLOW + """
                            ____________________________
                          / \\                          \\
                         |   | ☠️  Pirata: %s%s%s  👒
                          \\_ |
                             |      HP❤️: %s%s%s
                             |      HP Max❤️‍🔥: %s%s%s
                             |      Força💪: %s%s%s
                        """ + Tools.color.RESET,
                Tools.color.WHITE_BRIGHT, this.nome, Tools.color.YELLOW,
                Tools.color.WHITE_BRIGHT, this.hp, Tools.color.YELLOW,
                Tools.color.WHITE_BRIGHT, this.maxHp, Tools.color.YELLOW,
                Tools.color.WHITE_BRIGHT, this.forca, Tools.color.RESET);
    }


    /**
     * Método para subtrair o dano dum ataque
     *
     * @param ataque
     */
    public boolean recebeAtaque(int ataque) {
        this.hp -= ataque;
        System.out.println(Tools.color.YELLOW_BOLD_BRIGHT + this.getNome() + Tools.color.WHITE_BRIGHT +
                " sofre " + Tools.color.RED_BOLD_BRIGHT + ataque + Tools.color.WHITE_BRIGHT + " pontos de dano 💥");

        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(Tools.color.YELLOW_BOLD_BRIGHT + this.getNome() + Tools.color.WHITE_BRIGHT + " ha perdido\n");
            return false;
        }
        return true;
    }

    /**
     * Método de curação
     *
     * @param pocao
     * @return true se foi recebida a poção
     */
    public void recebePocao(int pocao) {
        if ((this.hp + pocao) > this.maxHp) {
            System.out.println(Tools.color.WHITE_BRIGHT + "\nVai perder " + Tools.color.RED_BRIGHT + ((this.hp + pocao) - this.maxHp) + Tools.color.WHITE_BRIGHT + " HP de cura da poção. Quer usar na mesma? (S/N)\n");

            if (!Tools.validarSimNao()) return;

        }
        this.hp += pocao;
        if (this.hp > this.maxHp) this.hp = this.maxHp;
    }

    /**
     * Método para guardar a força temporal dada pelas poções
     * será usada num turno do combate
     *
     * @param forca
     */
    public int recebeForca(int forca) {
        int forcaTemporal = 0;
        return forcaTemporal + forca;
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
