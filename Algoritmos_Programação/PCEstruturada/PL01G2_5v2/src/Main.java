import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        5. Acrescente a possibilidade de o utilizador calcular a soma e a média dos valores do array por linha, por coluna e
        no total.
        */
        Scanner in = new Scanner(System.in);
        System.out.println("Insira o número de linhas:");
        int li = in.nextInt();
        System.out.println("Insira o número de colunas:");
        int col = in.nextInt();
        int[][] tabuada = new int[li][col];
        double somaT = 0, soma = 0;

        // Inserir valores
        System.out.println("Insira os valores da tabuada");
        for (int i = 0; i < li; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Valor: ");
                tabuada[i][j] = in.nextInt();
                somaT += tabuada[i][j]; // soma total
            }
        }

        System.out.println("------------------------------------------------");
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < li; j++) {
                soma += tabuada[j][i];
            }
            System.out.println("Coluna " + (i + 1) + ": Soma " + soma + " Média: " + soma / li);
            soma = 0;
        }

        for (int i = 0; i < li; i++) {
            for (int j = 0; j < col; j++) {
                soma += tabuada[i][j];
            }
            System.out.println("Linha " + (i + 1) + ": Soma " + soma + " Média: " + soma / col);
            soma = 0;
        }

        System.out.println("Soma total: " + somaT);
        System.out.println("Média total: " + (somaT / (li * col)));


        // Mostrar tabuada
        System.out.println("--- Tabuada ---");
        for (int i = 0; i < li; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(tabuada[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
    }
}