import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        2. Faça um programa que guarde um array multidimensional de 3x3 com números aleatórios e o apresente no ecrã.
         */
        Random rnd = new Random();
        int[][] t3x3 = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                t3x3[i][j] = rnd.nextInt();
                System.out.print(t3x3[i][j] + "\t");
            }
            System.out.println();
        }
    }
}