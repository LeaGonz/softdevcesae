//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] num = new int[5];
        num[0] = 1;
        num[1] = 2;
        num[2] = 3;
        num[3] = 4;
        num[4] = 5;
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }

        String[] nomes = new String[]{"L", "U", "I", "S"};
        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }

        int[][] nums = new int[2][2];
        nums[0][0] = 1;
        nums[0][1] = 2;
        nums[1][0] = 3;
        nums[1][1] = 4;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.println(nums[i][j]);
            }
        }

        int[][][] coords = new int[2][2][2];
        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < coords[i].length; j++) {
                for (int k = 0; k < coords[i][j].length; k++) {
                    System.out.println(coords[i][j][k]);
                }
            }
        }
    }
}