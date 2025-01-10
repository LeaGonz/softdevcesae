package Ex_10;

public class Main {
    public static void main(String[] args) {
        Funcionario empleado1 = new Funcionario("Luis", 1300, Funcionario.Departamento.IT);

        empleado1.exibirDetalhes();
        empleado1.aumentarSalario(20);
        empleado1.exibirDetalhes();
    }
}
