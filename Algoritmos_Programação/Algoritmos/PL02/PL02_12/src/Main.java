import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        12. Utilize a estrutura SE para fazer um programa que retorne o nome de um produto a partir do código do mesmo.
        Considere os seguintes códigos:
        • 001 - Parafuso;
        • 002 - Porca;
        • 003 - Prego;
        • Para qualquer outro código indicar “Não definido”.
         */
        Scanner numin = new Scanner(System.in);

        System.out.println("Insira o código do produto, por favor:");
        int cod = numin.nextInt();

        if (cod == 001){
            System.out.println("O produto com código "+ cod +" é: Parafuso");
        } else if (cod == 002) {
            System.out.println("O produto com código "+ cod +" é: Porca");
        } else if (cod == 003) {
            System.out.println("O produto com código "+ cod +" é: Prego");
        } else {
            System.out.println("Código "+ cod +" não definido");
        }
    }
}