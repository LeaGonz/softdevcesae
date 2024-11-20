import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        7. O preço de um automóvel é calculado pela soma do preço de fábrica com o preço dos
        impostos (45% do preço de fábrica) e a percentagem do revendedor
        (28% do preço de fábrica). Faça um algoritmo que leia o nome do automóvel e o
        preço de fábrica e escreva o nome do automóvel e o preço final.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Nome do automóvel:");
        String nome = numin.nextLine();

        System.out.println("Preço de fábrica:");
        double preco = numin.nextDouble();

        double preco_final = ((preco * 0.45) + (preco * 0.28) + preco);
        System.out.println("Preço do " + nome + ": " +preco_final + "€");
    }
}