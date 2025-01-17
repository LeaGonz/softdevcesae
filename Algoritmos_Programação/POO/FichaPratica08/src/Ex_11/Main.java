package Ex_11;

public class Main {
    public static void main(String[] args) {
        Conta luis = new Conta("PT1234", 100, "Luis");
        Conta andrea = new Conta("PT5678", 0, "Andrea");

        luis.transferencia(50,andrea);
        System.out.println("----------------");
        luis.mostrarSaldo();
        andrea.mostrarSaldo();
        System.out.println("----------------");
        luis.depositar(525);
        andrea.depositar(1265);
        System.out.println("----------------");
        luis.levantar(126);
        andrea.levantar(3000);
    }
}
