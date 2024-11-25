import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        4. Pretende-se lendo a base e altura de um triângulo calcular a sua área.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Por favor, usar (,) alem do (.)");
        System.out.println("Altura do triângulo:");
        double altura = numin.nextDouble();

        System.out.println("Base do triângulo:");
        double base = numin.nextDouble();

        double area = (base * altura) / 2;
        System.out.println("A área do triângulo é: " + area);
    }
}