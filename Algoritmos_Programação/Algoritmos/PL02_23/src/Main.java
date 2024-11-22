import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        23. Crie um programa para multiplicar dois números sem recurso ao operador multiplicação.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("dois números sem recurso ao operador multiplicação.");
        System.out.println("Número 1:");
        double n1 = numin.nextDouble();
        System.out.println("Número 2:");
        double n2 = numin.nextDouble();
        double mul = 0;

        for (int i = 1; i <= Math.abs(n1); i++){
            mul += + Math.abs(n2);
        }
        if ((n1 > 0 && n2 > 0) || (n1 < 0 && n2 < 0)){
            System.out.println(mul);
        } else {
            System.out.println("-" + mul);
        }
    }
}