package Ex02;

public class Pessoa {
    private String nome;
    private int idade;
    private int telemovel;
    private String email;

    // construtor
    public Pessoa(String nome, int idade, int telemovel, String email) {
        this.nome = nome;
        this.idade = idade;
        this.telemovel = telemovel;
        this.email = email;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getNome() {
        return this.nome;
    }

    public int getTelemovel() {return this.telemovel;}

    public String getEmail() {return this.email;}
}
