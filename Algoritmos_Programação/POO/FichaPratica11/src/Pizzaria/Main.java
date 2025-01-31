package Pizzaria;

import Pizzaria.Enums.Tamanho;
import Pizzaria.Enums.Unidade;

public class Main {
    public static void main(String[] args) {
        Ingrediente mozzarella = new Ingrediente("I01", "Mozzarella", Unidade.GRAMAS, 5);
        Ingrediente molhoTomate = new Ingrediente("I02", "Molho Tomate", Unidade.LITROS, 15);
        Ingrediente molhoBbq = new Ingrediente("I03", "Molho BBQ", Unidade.LITROS, 15);
        Ingrediente cabra = new Ingrediente("I04", "Queijo Cabra", Unidade.GRAMAS, 5);
        Ingrediente cebola = new Ingrediente("I05", "Cebola", Unidade.GRAMAS, 5);
        Ingrediente salami = new Ingrediente("I06", "Salami", Unidade.GRAMAS, 5);

        Pizza napolitana = new Pizza("P01", "Pizza Napolitana", "Direto de Napoli para a tua mesa", 15.60,
                Tamanho.GRANDE);

        /* PROVA ADICIONAR INGREDIENTES */
        napolitana.adicionarIngrediente(new IngredientePizza(mozzarella, 10));
        napolitana.adicionarIngrediente(new IngredientePizza(molhoTomate, 0.150));
        napolitana.adicionarIngrediente(new IngredientePizza(molhoBbq, 160));
        napolitana.adicionarIngrediente(new IngredientePizza(cabra, 8));
        napolitana.adicionarIngrediente(new IngredientePizza(cebola, 6));
        napolitana.adicionarIngrediente(new IngredientePizza(salami, 10));

        /* LISTAR INGREDIENTES */
//        napolitana.listarIngredientes();

        /* EDITAR QUANTIDADE */
        //napolitana.editarQuantidade();

        /* REMOVER INGREDIENTE*/
        //napolitana.removerIngrediente();

        /* TOTAL CALORIAS */
        System.out.println("Total calorias da " + napolitana.getNome() + ":" + napolitana.caloriasTotal());
    }
}
