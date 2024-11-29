import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        3. Faça um programa que receba 10 valores inteiros e os coloque em um vetor. Em seguida exiba-os em ordem
        inversa à ordem de entrada.
         */
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Digite um numero " + (i + 1) + ": ");
            nums[i] = in.nextInt();
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.print(nums[i] + "\t");
        }
    }
}