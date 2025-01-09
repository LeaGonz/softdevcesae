package Ex_08;

public class Aluno {
    private String nome;
    private int idade;
    private int curso;
    private double media;

    // Construtor
    Aluno(String nome, int idade, int curso, double media) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.media = media;
    }
    // Metodos de instâncias
    public void situacao(){
        if (this.media >= 9.5)
            System.out.println("Aprovado");
        else
            System.out.println("Reprovado");
    }
}
