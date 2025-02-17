package entidades;

import Enums.Personagem;
import itens.ArmaPrincipal;
import itens.Consumivel;
import itens.ConsumivelCombate;
import itens.Pocao;
import jogo.Historia;
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

    @Override
    public void mostrarDetalhes() {

        super.mostrarDetalhes();

        System.out.printf(Tools.color.YELLOW + """
                             |   Nível🔰: %s%s%s
                             |   Ouro🪙:  %s%s%s
                             |   Arma⚔️:  %s%s%s
                             |   _________________________|_
                             \\_/___________________________/
                        
                        """ + Tools.color.RESET,
                Tools.color.WHITE_BRIGHT, this.nivel, Tools.color.YELLOW,
                Tools.color.WHITE_BRIGHT, this.ouro, Tools.color.YELLOW,
                Tools.color.WHITE_BRIGHT, (this.armaPrincipal != null ? this.armaPrincipal.getNome() : ""), Tools.color.YELLOW);
    }

    /**
     * Método atacar dum herói a um NPC
     *
     * @param npc
     * @return
     */
    public abstract boolean atacar(NPC npc);


    /**
     * Métodos de subida de nivel do herói
     * COM parametros o ouro é recebido do NPC
     * SEM parametro o ouro é de uma armadilha
     *
     * @param npc
     */
    public void subirNivel(NPC npc) {
        // Adicionar ouro NPC -> herói
        this.ouro += npc.getOuro();
        // Aumentar nível
        this.nivel += 1;
        // Aumentar força
        this.setForca(this.getForca() + 1);
        // Aumentar vida (HP)
        this.setMaxHp(this.getMaxHp() + 10);
        this.setHp(this.getHp() + 10);
        // Ativamos de novo o ataque especial
        this.ataqueEspecialUsado = false;
        // Mensagem
        System.out.println(Tools.color.YELLOW_BOLD_BRIGHT + this.getNome() + Tools.color.WHITE_BRIGHT + " ha subido de nivel");
    }

    public void subirNivel() {
        // Aumentar nível
        this.nivel += 1;
        // Aumentar força
        this.setForca(this.getForca() + 1);
        // Aumentar vida (HP)
        this.setMaxHp(this.getMaxHp() + 10);
        this.setHp(this.getHp() + 10);
        // Mensagem
        System.out.println(Tools.color.YELLOW_BOLD_BRIGHT + this.getNome() + Tools.color.WHITE_BRIGHT + " ha subido de nivel");
    }

    /**
     * Método para escolher o tipo de ataque (se for possível) entre normal, especial ou consumível
     *
     * @return
     */
    public int tipoAtaque() {
        int ataque, escolha, maxEscolha;
        do {
            System.out.print(Tools.color.WHITE_BRIGHT);
            // Se há consumíveis e arma
            if (!this.inventario.isEmpty() && this.armaPrincipal != null) {
                System.out.println("1- Ataque sem Arma" +
                        "\n2- Ataque com Arma" +
                        "\n3- Ataque Especial (uso único)" +
                        "\n4- Ataque Consumível" +
                        "\n5- Poções");
                maxEscolha = 5;
                // Se só há consumíveis
            } else if (!this.inventario.isEmpty()) {
                System.out.println("1- Ataque sem Arma\n2- Ataque Consumível\n3- Poções");
                maxEscolha = 3;
                // Se só tem arma
            } else if (this.armaPrincipal != null) {
                System.out.println("1- Ataque sem Arma\n2- Ataque com Arma\n3- Ataque Especial (uso único)");
                maxEscolha = 3;
            } else {
                // Se não tem arma
                return this.getForca();
            }

            System.out.println();
            escolha = Tools.validarEscolhaNum(1, maxEscolha);
            System.out.println();

            ataque = switch (escolha) {
                case 2 -> (this.armaPrincipal != null) ? this.armaPrincipal.getAtaque() : usarConsumivelCombate();
                case 3 -> (this.armaPrincipal != null) ? ataqueEspecial() : usarPocao();
                case 4 -> usarConsumivelCombate();
                case 5 -> usarPocao();
                default -> 0;
            };

            // Entramos nesta validação se precisarmos de repetir o menu de ataque
            if (ataque == -1) {
                ataque = this.getForca();
                continue;
            }

            // Validaçao se foi ussada uma poção que so da vida, retornamos forçã base
            if (ataque == 0) return this.getForca();

            if ((this.armaPrincipal == null && escolha == 2) || escolha == 4) return ataque;

            // Somamos a escolha + a força do herói
            ataque += this.getForca();

        } while (ataque == this.getForca());

        return ataque;
    }

    public void mudarHeroi(Personagem nome) {
        this.setNome(nome);

        // Criamos uma cópia do ArrayList
        ArrayList<Consumivel> copiaInventario = new ArrayList<>(this.inventario);

        if (nome == Personagem.Sanji) {
            if (this.armaPrincipal != null)
                this.armaPrincipal = new ArmaPrincipal("Diable Jambe Boots 🔥", 10, 10, 100, Personagem.Sanji);

            for (Consumivel consumivel : copiaInventario) {
                if (consumivel instanceof ConsumivelCombate) {
                    this.inventario.remove(consumivel);
                    this.inventario.add(new ConsumivelCombate("Faca de Cozinha 🔪", 5, Personagem.Sanji, 20));
                }
            }
        }

        if (nome == Personagem.Zoro) {
            if (this.armaPrincipal != null)
                this.armaPrincipal = new ArmaPrincipal("Espada Enma ⚔️", 10, 10, 100, Personagem.Zoro);

            for (Consumivel consumivel : copiaInventario) {
                if (consumivel instanceof ConsumivelCombate) {
                    this.inventario.remove(consumivel);
                    this.inventario.add(new ConsumivelCombate("Garrafa de Sake 🍶", 5, Personagem.Zoro, 20));
                }
            }
        }

        if (nome == Personagem.Luffy) {
            if (this.armaPrincipal != null)
                this.armaPrincipal = new ArmaPrincipal("Chapéu de Palha 👒", 10, 10, 100, Personagem.Luffy);

            for (Consumivel consumivel : copiaInventario) {
                if (consumivel instanceof ConsumivelCombate) {
                    this.inventario.remove(consumivel);
                    this.inventario.add(new ConsumivelCombate("Pedaço do Mastro Principal 🪵", 5, Personagem.Luffy, 20));
                }
            }
        }

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
        atualizarConsumiveis();

        // Saimos se não há poções
        if (consuCombate.isEmpty()) {
            System.out.println(Tools.color.RED + "\nSem consumíveis de combate para usar!\n" + Tools.color.WHITE_BRIGHT);
            return -1;
        }

        System.out.println(Tools.color.YELLOW_BRIGHT + "\nConsumíveis de combate\n" + Tools.color.WHITE_BRIGHT);

        // Listamos poções
        for (int i = 0; i < consuCombate.size(); i++) {
            System.out.println((i + 1) + "- " + consuCombate.get(i).getNome() + " | Ataque Instantâneo: " + consuCombate.get(i).getAtaqueInstantaneo());
        }

        System.out.println();
        int escolha = Tools.validarEscolhaNum(0, consuCombate.size());

        // Se escolher 0 para sair e voltar ao menu anterior
        if (escolha == 0) return -1;

        // Apagar o consumível do inventario principal
        this.inventario.remove(consuCombate.get(escolha - 1));

        // Print do uso da poção
        Historia.combateConsumivelCombate(consuCombate.get(escolha - 1));

        return consuCombate.get(escolha - 1).getAtaqueInstantaneo();
    }

    /**
     * Método listar e usar poções dum herói
     */
    public int usarPocao() {
        atualizarConsumiveis();

        // Saimos se não há poções
        if (pocoes.isEmpty()) {
            System.out.println(Tools.color.RED + "\nSem poções para usar!\n" + Tools.color.WHITE_BRIGHT);
            return -1;
        }

        System.out.println(Tools.color.YELLOW_BRIGHT + "\nPoções\n" + Tools.color.WHITE_BRIGHT);
        // Listamos poções
        for (int i = 0; i < pocoes.size(); i++) {
            System.out.println((i + 1) + "- " + pocoes.get(i).getNome() + " | Vida a curar: " + pocoes.get(i).getVidaCurar() +
                    " | Aumento da Força: " + pocoes.get(i).getAumentoForca());
        }

        System.out.println();
        int escolha = Tools.validarEscolhaNum(0, pocoes.size());

        // Se escolher 0 para sair e voltar ao menu anterior
        if (escolha == 0) return -1;

        // Apagar o consumível do inventario principal
        this.inventario.remove(pocoes.get(escolha - 1));

        // Cura da vida
        if (pocoes.get(escolha - 1).getVidaCurar() > 0) this.recebePocao(pocoes.get(escolha - 1).getVidaCurar());

        // Print do uso da poção
        Historia.combatePocao(pocoes.get(escolha - 1));

        // Aumento da força
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
            System.out.println(Tools.color.RED + "O ataque especial já foi usado" + Tools.color.WHITE_BRIGHT);
            return -1;
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
        return this.ouro;
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
        this.ouro += ouro;
    }

    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    public void setInventario(Consumivel inventario) {
        this.inventario.add(inventario);
    }
}
