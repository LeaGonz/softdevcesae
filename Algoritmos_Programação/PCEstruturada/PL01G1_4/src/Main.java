import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        4. Faça um programa que utilize uma estrutura de repetição para ler 50 números armazenando-os em um vetor e
        calcule e exiba a média aritmética deles. Em seguida o programa deve apresentar todos os valores armazenados
        no vetor que sejam menores que a média.
         */
        Random rnd = new Random();
        int[] nums = new int[50];
        double soma = 0;
        double media = 0;
        System.out.println("Números totais");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rnd.nextInt(50);
            soma += nums[i];
            System.out.print(nums[i] + "\t");
            if ((i + 1) % 11 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n-------------------------------------------");
        media = soma / nums.length;
        System.out.println("\nA média é: " + media + "\n");
        System.out.println("Números menores que a média");
        System.out.println("-------------------------------------------");

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < media) {
                System.out.print(nums[i] + "\t");
                if ((i + 1) % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println("\n-------------------------------------------");
    }
}