package Pizzaria;

public class IngredientePizza {
    Ingrediente ingrediente;
    private double quantidade;

    public IngredientePizza(Ingrediente ingrediente, double quantidade) {
        this.ingrediente = ingrediente;
        this.quantidade = quantidade;
    }

    // Getters
    public Ingrediente getIngrediente() {
        return this.ingrediente;
    }
    public double getQuantidade() {
        return this.quantidade;
    }
    // Setter
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
