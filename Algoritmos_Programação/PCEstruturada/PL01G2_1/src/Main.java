import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        1. Crie um programa que utilize um array multidimensional que simule a tabuada de 10x10. Deve utilizar ciclos para
        preenchimento do array e aquando da execução da aplicação escrever a todo o array.
         */
        Scanner in = new Scanner(System.in);

        System.out.println("Quantas linhas quer?");
        int linas = in.nextInt();
        System.out.println("Quantas colunas quer?");
        int colunas = in.nextInt();

        int[][] tabuada = new int[linas][colunas];

        for (int i = 0; i < linas; i++) {
            for (int j = 0; j < colunas; j++) {
                tabuada[i][j] = (i + 1) * (j + 1);
                System.out.print(tabuada[i][j] + "\t");
            }
            System.out.println();
        }
    }
}