package entidades;

import items.ItemHeroi;
import java.util.ArrayList;

public class Vendedor {
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
    public void imprimirLoja(){
        System.out.println("MOSTRAMOS 10 ITENS ALEATORIOS E AS SUAS ESPECIFICACOES");
    }

    public void adicionarItem(ItemHeroi item){
        this.loja.add(item);

    }
    public void vender(Heroi heroiComprador){

    }
}
