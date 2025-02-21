package Tacos;

public abstract class Taco {
    private String tipo;

    public Taco(String tipo) {
        this.tipo = tipo;
    }

    public abstract void prepare();

    public abstract void bake();

    public abstract void box();

    // GETTERS

    public String getTipo() {
        return tipo;
    }
}
