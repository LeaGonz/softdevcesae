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
    public Heroi(Personagem nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.inventario = new ArrayList<>();
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
     * Método para escolher o tipo de ataque (se for possível) entre normal, especial ou consumível
     *
     * @return
     */
    public int tipoAtaque() {
        int escolha, ataque;
        do {
            // Se há algum consumível
            if (!this.inventario.isEmpty()) {
                // Se tem arma o herói
                if (this.armaPrincipal != null) {
                    System.out.println("Escolha o tipo de ataque:\n1- Ataque Normal\n2- Ataque Especial (uso único)\n3- Ataque Consumível");
                    escolha = Tools.validarEscolhaNum();
                    ataque = switch (escolha) {
                        case 1 -> this.getForca() + this.armaPrincipal.getAtaque();
                        case 2 -> ataqueEspecial();
                        case 3 -> usarConsumivelCombate();
                        default -> 0;
                    };
                    // Se só há consumíveis
                } else {
                    System.out.println("Escolha o tipo de ataque: 1- Ataque Consumível");
                    escolha = Tools.validarEscolhaNum();
                    if (escolha == 1) ataque = usarConsumivelCombate();
                    else ataque = 0;
                }
                // Se só tem arma o herói
            } else if (this.armaPrincipal != null) {
                System.out.println("Escolha o tipo de ataque: 1- Ataque Normal\n2- Ataque Especial (uso único)");
                escolha = Tools.validarEscolhaNum();
                ataque = switch (escolha) {
                    case 1 -> this.getForca() + this.armaPrincipal.getAtaque();
                    case 2 -> ataqueEspecial();
                    default -> 0;
                };
                // Se não tem arma só ataca com força
            } else {
                ataque = this.getForca();
            }
        } while (ataque == 0);
        return ataque;
    }

    /**
     * Método para o uso do consumivel tipo combate
     *
     * @return o valor do ataque selecionado / ou 0 se não há consumível
     */
    private int usarConsumivelCombate() {
        // ArrayList para adicionar os consumíveis tipo combate
        ArrayList<ConsumivelCombate> consuCombate = new ArrayList<>();
        int index = 1;

        System.out.println("Consumíveis de combate:");

        for (Consumivel consumivel : this.inventario) {

            // Verificamos o tipo do consumível
            if (consumivel instanceof ConsumivelCombate) {
                consuCombate.add((ConsumivelCombate) consumivel);
                System.out.print(index + "- ");
                consumivel.mostrarDetalhes();
                index++;
            }
        }

        // Se não foi adicionado nada no ArrayList, terminamos função
        if (consuCombate.isEmpty()) {
            return 0;
        }

        System.out.print("Escolha: ");
        int escolha = Tools.validarEscolhaNum();
        this.inventario.remove(consuCombate.get(escolha - 1));

        return consuCombate.get(escolha - 1).getAtaqueInstantaneo();
    }

    /**
     * Método para validar se é possível o uso do ataque especial
     *
     * @return o valor do ataque especial se não foi usado
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

    /**
     * Método para alterar o ouro do herói
     * @param ouroHeroi
     */
    protected void ouroHeroi(int ouroHeroi) {
        this.ouro += ouroHeroi;
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
