import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    /*
    Soma de dois inteiros
    */
        Scanner in = new Scanner(System.in);

        System.out.println("Insira um número");
        //String numero1 = in.nextLine();
        //int n1 = Integer.parseInt(numero1);
        //int numero1 = in.nextInt();
        double numero1 = in.nextDouble();

        System.out.println("Insira outro número");
        //String numero2 = in.nextLine();
        //int n2 = Integer.parseInt(numero2);
        //int numero2 = in.nextInt();
        double numero2 = in.nextDouble();

        //String soma = numero1 + numero2;
        //int soma = numero1 + numero2;
        double soma = numero1 + numero2;
        System.out.println("A soma é: " + soma);
    }
}