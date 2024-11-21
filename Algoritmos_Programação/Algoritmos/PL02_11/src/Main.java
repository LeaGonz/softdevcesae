import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        11. Faça um programa que receba 3 valores que representarão os lados de um triângulo
        e verifique se os valores formam um triângulo e classifique esse triângulo como:
        • Equilátero (3 lados iguais);
        • Isósceles (2 lados iguais);
        • Escaleno (3 lados diferentes).
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira os valores dos lados do triângulo.");
        System.out.println("Valor 1:");
        double n1 = numin.nextDouble();
        System.out.println("Valor 2:");
        double n2 = numin.nextDouble();
        System.out.println("Valor 3:");
        double n3 = numin.nextDouble();

        if ((n1+n2+n3) == 0){
            System.out.println("Nenhum dos lados pode ser igual a zero");
        } else if (n1 > (n2+n3) || n2 > (n1+n3) || n3 > (n1+n2)) {
            System.out.println("Um lado não pode ser maior do que a soma dos outros dois");
        } else if (n1 == n2 && n1 == n3) {
            System.out.println("O triângulo é Equilátero");
        } else if (n1 == n2  || n1 == n3 || n2 == n3){
            System.out.println("O triângulo é Isósceles");
        } else {
            System.out.println("O triângulo é Escaleno");
        }
    }
}