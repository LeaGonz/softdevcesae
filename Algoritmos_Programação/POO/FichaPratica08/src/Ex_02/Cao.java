package Ex_02;

public class Cao {
    private String nome;
    private String raca;
    private String latido = "Au au au";

    // Metodos construtor
    Cao(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    // Get
    public String getNome() {
        return this.nome;
    }

    public String getRaca() {
        return this.raca;
    }

    public String getLatido() {
        return this.latido;
    }

    // Set
    public void setLatido(String latido) {
        this.latido = latido;
    }
}
