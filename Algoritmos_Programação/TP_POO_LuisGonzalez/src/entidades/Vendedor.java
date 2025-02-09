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
        System.out.println("Itens à venda:\n");
        for (int i = 0; i < this.itensMostrados.size(); i++) {
            System.out.print((i + 1) + "- ");
            this.itensMostrados.get(i).mostrarDetalhes();
        }
    }

    public void adicionarItem(ItemHeroi item) {
        this.loja.add(item);
    }

    /**
     * Método recebe o Herói como parâmetro, e verifica se a compra pode ser
     * efetuada
     *
     * @param heroiComprador
     */
    public void vender(Heroi heroi) {
        System.out.print("Escolha um item: ");
        int escolha = Tools.validarEscolhaNum();
        ItemHeroi item = this.itensMostrados.get(escolha - 1);

        // Verificar se pode comprar
        if (!item.getHeroisPermitidos().contains(Personagem.Geral)) {
            if (!item.getHeroisPermitidos().contains(heroi.getNome())) {
                Historia.vendedorItemNao(heroi, item);
                return;
            }
        }

        // Se tem ouro suficiente
        if (heroi.getOuro() >= item.getPreco()) {
            heroi.setOuro(-item.getPreco());
            Historia.vendedorItemSim(heroi, item);

            // Se for ArmaPrincipal
            if (item instanceof ArmaPrincipal) {
                heroi.setArmaPrincipal((ArmaPrincipal) item);
            }
            // Se for Consumível
            else if (item instanceof Consumivel) {
                heroi.setInventario((Consumivel) item);
            }
        }
    }
}
