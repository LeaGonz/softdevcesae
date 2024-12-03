import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        4. Altere a aplicação anterior permitindo ao utilizador escolher o número de linhas e colunas do array.
         */
        Scanner in = new Scanner(System.in);
        System.out.println("Insira o número de linhas:");
        int li = in.nextInt();
        System.out.println("Insira o número de colunas:");
        int col = in.nextInt();

        int[][] t3x3 = new int[li][col];

        System.out.println("Insira os valores da tabuada");
        for (int i = 0; i < li; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Valor: ");
                t3x3[i][j] = in.nextInt();
            }
        }
        System.out.println("--- Tabuada ---");
        for (int i = 0; i < li; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(t3x3[i][j] + "\t");
            }
            System.out.println();
        }
    }
}