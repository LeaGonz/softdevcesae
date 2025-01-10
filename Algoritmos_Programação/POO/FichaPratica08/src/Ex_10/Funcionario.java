package Ex_10;

public class Funcionario {
    private String nome;
    private double salario;
    private Departamento departamento;

    // construtor
    Funcionario(String nome, double salario, Departamento departamento) {
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    public enum Departamento {
        IT, RRHH, DESENVOLVEDOR, DESING
    }

    // Metodos de instãncias
    public void aumentarSalario(double aumento) {
        this.salario = (this.salario * (aumento / 100) + this.salario);
        System.out.println("Aumento feito com sucesso.");
    }

    public void exibirDetalhes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Salario: " + this.salario);
        System.out.println("Departamento: " + this.departamento);
    }
}
