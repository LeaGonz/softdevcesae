package Ex05;

public class Pessoa {
    private String nome;
    private int idade;
    private String email;
    private int telemovel;

    public Pessoa(String nome, int idade, String email, int telemovel) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telemovel = telemovel;
    }

    public void exibirPessoa() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("E-mail: " + email);
        System.out.println("Telemovel: " + telemovel);
    }
}
