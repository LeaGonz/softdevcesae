package entidades;

import Enums.Personagem;
import itens.ArmaPrincipal;
import itens.Consumivel;
import itens.ConsumivelCombate;
import itens.Pocao;
import jogo.Tools;

import java.util.ArrayList;

public abstract class Heroi extends Entidade {
    private int nivel;
    private int ouro;
    private ArmaPrincipal armaPrincipal;
    private ArrayList<Consumivel> inventario;
    private ArrayList<ConsumivelCombate> consuCombate;
    private ArrayList<Pocao> pocoes;
    private boolean ataqueEspecialUsado;

    /**
     * Construtor
     *
     * @param nome
     * @param hp
     * @param forca
     * @param nivel
     * @param ouro
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
     * Método do ataque dos herois ao NPC
     *
     * @param npc
     * @return
     */
    public boolean ataqueHeroi(NPC npc) {
        int ataque = this.tipoAtaque();
        npc.recebeAtaque(ataque);
        System.out.println(this.getNome() + " ataca e causa " + ataque + " de dano!");

        // Se o NPC morrer
        if (!npc.vivo()) {
            // Adicionar ouro NPC -> herói
            this.ouroHeroi(npc.getOuro());
            // Aumentar nível
            this.nivel += 1;
            // Aumentar força
            this.setForca(this.getForca() + 1);
            // Aumentar vida (HP)
            this.setMaxHp(this.getMaxHp() + 10);
            System.out.println(npc.getNome() + " ha perdido");
            // Apagamos o NPC
            npc = null;
            return false;
        }
        return true;
    }

    /**
     * Método para escolher o tipo de ataque (se for possível) entre normal, especial ou consumível
     *
     * @return
     */
    public int tipoAtaque() {
        int ataque, escolha = 0;
        do {
            System.out.println("Escolha o tipo de ataque:");
            // Se há consumíveis e arma
            if (!this.inventario.isEmpty() && this.armaPrincipal != null) {
                System.out.println("1- Ataque sem Arma\n2- Ataque com Arma\n3- Ataque Especial (uso único)\n4- Ataque Consumível\n5- Poções");
                // Se só há consumíveis
            } else if (!this.inventario.isEmpty()) {
                System.out.println("1- Ataque sem Arma\n2- Ataque Consumível\n3- Poções");
                // Se só tem arma
            } else if (this.armaPrincipal != null) {
                System.out.println("1- Ataque sem Arma\n2- Ataque com Arma\n3- Ataque Especial (uso único)");
            } else {
                // Se não tem arma
                return this.getForca();
            }

            escolha = Tools.validarEscolhaNum();

            ataque = switch (escolha) {
                case 2 -> (this.armaPrincipal != null) ? this.armaPrincipal.getAtaque() : usarConsumivelCombate();
                case 3 -> (this.inventario.isEmpty()) ? ataqueEspecial() : usarPocao();
                case 4 -> usarConsumivelCombate();
                case 5 -> usarPocao();
                default -> 0;
            };

            // Somamos a escolha + o ataque com só força
            ataque += this.getForca();

        } while (ataque == this.getForca() && escolha != 1);

        return ataque;
    }

    /**
     * Método para preencher os consumíveis a usar pelo herói
     * durante o fora da batalha
     */
    public void atualizarConsumiveis() {
        // ArrayList para adicionar os consumíveis tipo combate
        consuCombate = new ArrayList<>();
        // ArrayList para adicionar as poções
        pocoes = new ArrayList<>();

        for (Consumivel consumivel : this.inventario) {

            if (consumivel instanceof ConsumivelCombate) {
                consuCombate.add((ConsumivelCombate) consumivel);
            }

            if (consumivel instanceof Pocao) {
                pocoes.add((Pocao) consumivel);
            }
        }
    }

    /**
     * Método para o uso do consumivel tipo combate
     *
     * @return o valor do ataque selecionado / ou 0 se não há consumível
     */
    public int usarConsumivelCombate() {
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
     * Método listar e usar poções dum herói
     */
    public int usarPocao() {
        atualizarConsumiveis();

        // Saimos se não há poções
        if (pocoes.isEmpty()) {
            System.out.println("Sem poções para usar!");
            return 0;
        }

        System.out.println("Poções:");
        // Listamos poções
        for (int i = 0; i < pocoes.size(); i++) {
            System.out.println((i + 1) + "- " + pocoes.get(i).getNome());
            pocoes.get(i).mostrarDetalhes();
        }

        System.out.println("Escolha: ");
        int escolha = Tools.validarEscolhaNum();

        // Apagar o consumível do inventario principal
        this.inventario.remove(pocoes.get(escolha - 1));

        if (pocoes.get(escolha - 1).getVidaCurar() > 0) this.recebePocao(pocoes.get(escolha - 1).getVidaCurar());

        if (pocoes.get(escolha - 1).getAumentoForca() > 0)
            return this.recebeForca(pocoes.get(escolha - 1).getAumentoForca());

        return 0;
    }

    /**
     * Método para validar se é possível o uso do ataque especial
     *
     * @return o valor do ataque especial se não foi usado
     */
    public int ataqueEspecial() {
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
     *
     * @param ouroHeroi
     */
    public void ouroHeroi(int ouroHeroi) {
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
