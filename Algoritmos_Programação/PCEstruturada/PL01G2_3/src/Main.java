import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        3. Altere a aplicação anterior permitindo ao utilizador preencher o array com os valores que pretender.
         */
        Scanner in = new Scanner(System.in);
        int[][] t3x3 = new int[3][3];

        System.out.println("Insira os valores da tabuada");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Valor(" + i + "," + j + "): ");
                t3x3[i][j] = in.nextInt();
            }
        }
        System.out.println("--- Tabuada ---");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(t3x3[i][j] + "\t");
            }
            System.out.println();
        }
    }
}