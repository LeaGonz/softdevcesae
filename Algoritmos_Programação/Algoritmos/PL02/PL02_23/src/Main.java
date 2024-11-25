import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        23. Crie um programa para multiplicar dois números sem recurso ao operador multiplicação.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Multiplicar dois números sem recurso ao operador multiplicação.");
        System.out.println("Número 1:");
        int n1 = numin.nextInt();
        System.out.println("Número 2:");
        int n2 = numin.nextInt();

        if (n1 > n2){
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        int mul = 0;
        for (int i = 1; i <= Math.abs(n1); i++){
            mul += + Math.abs(n2);
        }
        if ((n1 > 0 && n2 > 0) || (n1 < 0 && n2 < 0)){
            System.out.println(n1 + " x " + n2 + " = " + mul);
        } else {
            System.out.println(n1 + " x " + n2 + " = " + "-" + mul);
        }
    }
}