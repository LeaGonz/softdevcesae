package entidades;

import Enums.Personagem;
import jogo.Historia;
import jogo.Tools;

/**
 * Classe abstrata que representa uma entidade no jogo. Essa entidade pode ser um NPC, um herói
 */
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
     * Exibe os detalhes da entidade, como nome, vida, vida máxima e força.
     */
    public void mostrarDetalhes() {
        System.out.printf(Tools.color.YELLOW + """
                            ______________________________
                          / \\                            \\
                         |   | ☠️  Pirata: %s%s%s  👒
                          \\_ |
                             |   HP❤️: %s%s%s
                             |   HP Max❤️‍🔥: %s%s%s
                             |   Força💪: %s%s%s
                        """ + Tools.color.RESET,
                Tools.color.WHITE_BRIGHT, this.nome, Tools.color.YELLOW,
                Tools.color.WHITE_BRIGHT, this.hp, Tools.color.YELLOW,
                Tools.color.WHITE_BRIGHT, this.maxHp, Tools.color.YELLOW,
                Tools.color.WHITE_BRIGHT, this.forca, Tools.color.RESET);
    }


    /**
     * Método para subtrair a vida da entidade quando ela recebe um ataque.
     * Se a vida atingir 0, a entidade é considerada derrotada.
     *
     * @param ataque O valor do dano recebido.
     * @return Retorna {@code false} se a entidade for derrotada , {@code true} caso contrário.
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
     * Método que permite ao herói usar uma poção para curar parte de sua vida.
     *
     * @param pocao
     * @return Retorna {@code true} se a poção for usada com sucesso, ou {@code false} se não for usada.
     */
    public boolean recebePocao(int pocao) {
        if ((this.hp + pocao) > this.maxHp) {
            System.out.println(Tools.color.WHITE_BRIGHT + "\nVai perder " + Tools.color.RED_BRIGHT + ((this.hp + pocao) - this.maxHp) + Tools.color.WHITE_BRIGHT + " HP de cura da poção. Quer usar na mesma? (S/N)\n");

            if (!Tools.validarSimNao()) return false;

        }
        this.hp += pocao;
        if (this.hp > this.maxHp) this.hp = this.maxHp;
        return true;
    }

    /**
     * Método para aumentar temporariamente a força da entidade.
     *
     * @param forca A quantidade de força adicional a ser recebida.
     * @return Retorna o valor total da força, incluindo a força temporária.
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
