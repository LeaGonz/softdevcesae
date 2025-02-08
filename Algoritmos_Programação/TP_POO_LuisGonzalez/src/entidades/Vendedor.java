package entidades;

import Enums.Personagem;
import itens.ItemHeroi;

import java.util.ArrayList;
import java.util.Random;

public class Vendedor {
    private Random rnd = new Random();

    /**
     * Items que o herói poderá comprar
     */
    protected ArrayList<ItemHeroi> loja;

    public Vendedor() {
        this.loja = new ArrayList<>();
    }

    /**
     * Método para mostrar 10 itens aleatórios ao herói
     */
    public void imprimirLoja() {
        int ITEM_MAX = 10;
        ArrayList<Integer> itensMostrados = new ArrayList<>();
        System.out.println("Itens à venda:\n");
        int item;
        for (int i = 0; i < ITEM_MAX; i++) {
            item = rnd.nextInt(this.loja.size());
            if (!itensMostrados.contains(item)) {
                itensMostrados.add(item);
                System.out.print(i + 1 + "- ");
                this.loja.get(item).mostrarDetalhes();
            } else {
                i--;
            }
        }
    }

    public void adicionarItem(ItemHeroi item) {
        this.loja.add(item);
    }

    /**
     * Método recebe o Herói como parâmetro, e verifica se a compra pode ser
     * efetuada
     * @param heroiComprador
     */
    public void vender(Heroi heroiComprador) {

    }
}
