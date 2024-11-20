import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        5. Faça um programa que receba um valor que é o valor pago, um segundo valor
        que é o preço do produto e retorne o troco a ser dado.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Cual é o preço do produto?");
        double preco = numin.nextDouble();

        System.out.println(("Valor a pagar:"));
        double pagar = numin.nextDouble();

        double troco = pagar - preco;
        //System.out.println("Troco: " + ((pagar + preco) - pagar));

        if (troco > 0){
            System.out.println("O troco é: " + troco);
        } else if (troco < 0) {
            //System.out.println("Falta pagar: " + troco * -1);
            System.out.println("Falta pagar: " + Math.abs(troco));
        } else {
            System.out.println("Não tem troco");
        }
    }
}