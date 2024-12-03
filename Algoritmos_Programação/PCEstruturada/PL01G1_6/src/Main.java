import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        6. Faça um programa que peça ao utilizador um conjunto de nomes e os guarda num vetor. De seguida sorteie uma
        posição do vetor e escreva o nome que está nessa posição.
         */
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Quantos nomes quer guardar?");
        int quant = in.nextInt();
        in = new Scanner(System.in);

        String[] nomes = new String[quant];

        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Insira o nome "+(i+1)+":");
            nomes[i] = in.nextLine();
        }
        System.out.println("Nome aleatorio: " + nomes[rnd.nextInt(nomes.length)]);
    }
}