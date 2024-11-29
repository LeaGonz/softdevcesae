import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*
        5. Faça um programa que ordene de forma crescente e decrescente um vetor. Sugere-se pesquisa na internet pelo
        tópico: “java bubble sort”.
         */
        Random rnd = new Random();
        int[] nums = new int[10];
        boolean sort;
        // Crescente
        System.out.println("Números sem ordenar");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rnd.nextInt(20);
        }
        MostrarArray(nums);
        Crescente(nums);
        MostrarArray(nums);
        Decrescente(nums);
        MostrarArray(nums);
    }

    private static void Decrescente(int[] nums) {
        int temp;
        System.out.println("\nNúmeros ordenados de forma Decrescente");
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    private static void Crescente(int[] nums) {
        int temp;
        System.out.println("\nNúmeros ordenados de forma crescente");
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    private static void MostrarArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }
}