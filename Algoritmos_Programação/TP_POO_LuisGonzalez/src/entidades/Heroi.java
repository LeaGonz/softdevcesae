package entidades;

import Enums.Personagem;
import itens.ArmaPrincipal;
import itens.Consumivel;
import itens.ConsumivelCombate;
import jogo.Tools;

import java.util.ArrayList;

public abstract class Heroi extends Entidade {
    private int nivel;
    private int ouro;
    private ArmaPrincipal armaPrincipal;
    private ArrayList<Consumivel> inventario;
    private boolean ataqueEspecialUsado;

    /**
     * Construtor
     *
     * @param nome
     * @param hp
     * @param forca
     * @param nivel
     * @param ouro
     * @param armaPrincipal
     * @param inventario
     * @param ataqueEspecialUsado
     */
    public Heroi(Personagem nome, int hp, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, boolean ataqueEspecialUsado) {
        super(nome, hp, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = inventario;
        this.ataqueEspecialUsado = false;
    }

    /**
     * Método atacar dum herói a um NPC
     *
     * @param npc
     * @return
     */
    public abstract boolean atacar(NPC npc);

    /**
     * Método listar e usar poções dum herói
     */
    public void usarPocao() {

    }

    /**
     * Método auxiliar ataque de herói, reutilização de código
     *
     * @param npc
     * @return
     */
    public boolean atacaHeroi(NPC npc) {
        int ataque = tipoAtaque();

        npc.recebeAtaque(ataque);
        System.out.println(this.getNome() + " ataca e causa " + ataque + " de dano!");

        // Verificar HP do NPC
        if (!npc.vivo()) {
            System.out.println(npc.getNome() + " ha perdido");
            npc = null;
            return false;
        }
        return true;
    }

    /**
     * Método para escolher o tipo de ataque (se for possível)
     *
     * @return
     */
    private int tipoAtaque() {
        int escolha, ataque = 0;
        do {
            if (!this.inventario.isEmpty()) {
                if (this.armaPrincipal != null) {
                    System.out.println("Escolha o tipo de ataque:\n1- Ataque Normal\n2- Ataque Especial (uso único)\n3- Ataque Consumível");
                    escolha = Tools.validarEscolhaNum();
                    switch (escolha) {
                        case 1:
                            ataque = this.getForca() + this.armaPrincipal.getAtaque();
                            break;
                        case 2:
                            ataque = ataqueEspecial();
                            break;
                        case 3:
                            ataque = usarConsumivelCombate();
                            break;
                        default:
                            break;
                    }
                    ;
                } else {
                    System.out.println("Escolha o tipo de ataque: 1- Ataque Consumível");
                }
            } else if (this.armaPrincipal != null) {
                System.out.println("Escolha o tipo de ataque: 1- Ataque Normal\n2- Ataque Especial (uso único)");
                ataque = this.getForca() + this.armaPrincipal.getAtaque();
            } else {
                ataque = this.getForca();
            }
        } while (ataque == 0);
        return ataque;
    }

    private int usarConsumivelCombate() {
        ArrayList<ConsumivelCombate> consuCombate = new ArrayList<>();
        int index = 1;

        System.out.println("Consumíveis de combate:");

        for (Consumivel consumivel : this.inventario) {

            // Só adicionamos os consumíveis de tipo combate ao ArrayList consuCombate
            if (consumivel instanceof ConsumivelCombate) {
                consuCombate.add((ConsumivelCombate) consumivel);
                System.out.print(index + "- ");
                consumivel.mostrarDetalhes();
                index++;
            }
        }

        if (consuCombate.isEmpty()) {
            return 0;
        }

        System.out.print("Escolha: ");
        int escolha = Tools.validarEscolhaNum();
        this.inventario.remove(consuCombate.get(escolha - 1));

        return consuCombate.get(escolha - 1).getAtaqueInstantaneo();
    }

    /**
     * Método para validar o uso do ataque especial
     *
     * @return o valor do ataque especial se for possível
     */
    private int ataqueEspecial() {
        if (!this.ataqueEspecialUsado) {
            this.ataqueEspecialUsado = true;
            return this.armaPrincipal.getAtaqueEspecial();
        } else {
            System.out.println("O ataque especial já foi usado");
            return 0;
        }
    }


    // ******************************** GETTERS / SETTERS ********************************

    /**
     * Getters
     */
    public int getNivel() {
        return nivel;
    }

    public int getOuro() {
        return ouro;
    }

    public ArmaPrincipal getArmaPrincipal() {
        return armaPrincipal;
    }

    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }

    /**
     * Setters
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    public void setInventario(Consumivel inventario) {
        this.inventario.add(inventario);
    }
}
