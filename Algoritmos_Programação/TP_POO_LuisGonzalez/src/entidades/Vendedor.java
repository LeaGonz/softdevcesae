package entidades;

import Enums.Personagem;
import itens.ArmaPrincipal;
import itens.Consumivel;
import itens.ItemHeroi;
import jogo.Historia;
import jogo.Tools;

import java.util.ArrayList;
import java.util.Random;

public class Vendedor {
    private Random rnd = new Random();
    private ArrayList<ItemHeroi> loja;
    private ArrayList<ItemHeroi> itensMostrados;

    /**
     * Construtor
     */
    public Vendedor() {
        this.loja = new ArrayList<>();
        this.itensMostrados = new ArrayList<>();
    }

    /**
     * Método para mostrar 10 itens aleatórios ao herói
     */
    public void mostrarLoja() {
        // Preencher os 10 itens a mostrar
        if (this.itensMostrados.isEmpty()) {
            ArrayList<Integer> indices = new ArrayList<>();
            int ITEM_MAX = 10;
            while (indices.size() < ITEM_MAX) {
                int item = rnd.nextInt(this.loja.size());
                if (!indices.contains(item)) {
                    indices.add(item);
                    itensMostrados.add(this.loja.get(item));
                }
            }
        }

        // Mostrar os 10 itens
        System.out.printf(Tools.color.YELLOW + """
                            __________________________________________________________________________________________________________________
                          / \\                                                                                                                \\
                         |   |                                                   🏮   %sLOJA%s   🏮
                          \\_ |                Nome                 Preço 🪙  Herói ☠️
                        """,
                Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW);
        for (int i = 0; i < this.itensMostrados.size(); i++) {
            System.out.printf("     | %-2s- ", (i + 1));
            this.itensMostrados.get(i).mostrarDetalhes();
        }
        System.out.printf("""
                     |   ______________________________________________________________________________________________________________|_
                     \\_/_______________________________________________________________________________________________________________/
                
                """ + Tools.color.RESET);
    }

    public void adicionarItem(ItemHeroi item) {
        this.loja.add(item);
    }

    /**
     * Método recebe o Herói como parâmetro, e verifica se a compra pode ser
     * efetuada
     *
     * @param heroi
     * @return
     */
    public boolean vender(Heroi heroi) {
        int escolha = Tools.validarEscolhaNum(0, this.itensMostrados.size());

        // Se 0, retorna FALSE e saímos do método
        if (escolha == 0) {
            Historia.vendedorDespedida();
            return false;
        }
        ;

        ItemHeroi item = this.itensMostrados.get(escolha - 1);

        // Verificar se pode comprar, se não, retorna TRUE
        if (!item.getHeroisPermitidos().contains(Personagem.Geral)) {
            if (!item.getHeroisPermitidos().contains(heroi.getNome())) {
                Historia.vendedorItemNao(heroi, item);
                return true;
            }
        }

        // Se tem ouro suficiente, descontamos o ouro do herói
        if (heroi.getOuro() >= item.getPreco()) {
            heroi.setOuro(-item.getPreco());
            Historia.vendedorItemSim(heroi, item);

            // Se for ArmaPrincipal adicionamos
            if (item instanceof ArmaPrincipal) {
                heroi.setArmaPrincipal((ArmaPrincipal) item);
            }
            // Se for Consumível adicionamos
            else if (item instanceof Consumivel) {
                heroi.setInventario((Consumivel) item);
            }
        }

        Tools.pausar();

        // Vendedor pergunta se quer comprar mais alguma coisa
        Historia.vendedorPerguntaMais();
        if (Tools.validarSimNao()) {
            return true;
        } else {
            Historia.vendedorDespedida();
            return false;
        }
    }

    public void limparItensMostrados() {
        this.itensMostrados.clear();
    }
}
