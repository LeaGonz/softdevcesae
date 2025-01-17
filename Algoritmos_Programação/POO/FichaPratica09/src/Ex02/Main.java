package Ex02;

public class Main {
    public static void main(String[] args) {
        Conta luis = new Conta("PT1234", 100, "Luis");
        Conta andrea = new Conta("PT5678", 0, "Andrea");

        luis.mostrarSaldo();
        luis.transferencia(50, andrea);
        luis.mostrarSaldo();
        System.out.println("----------------");
        System.out.println(luis.pedirEmprestimo(500));
        System.out.println(luis.pedirEmprestimo(25));
        luis.mostrarSaldo();

    }
}
