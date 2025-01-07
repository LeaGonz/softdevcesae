package Ex_01;

public class Pessoa {
    private String nome;
    private int idade;
    private double altura;

    // Metodo construtor
    Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }
    // Metodos get
    public String getNome() {
        return this.nome;
    }
    public int getIdade() {
        return this.idade;
    }
    public double getAltura() {
        return this.altura;
    }
    // Metodos set
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
