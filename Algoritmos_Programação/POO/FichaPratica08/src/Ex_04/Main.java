package Ex_04;

public class Main {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(20.3);

        System.out.printf("Area do círculo: %.2f\n", circulo1.area());
        System.out.printf("Circunferência do círculo: %.2f\n", circulo1.circunferencia());
    }
}
