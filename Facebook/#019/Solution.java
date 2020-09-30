import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 30.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(buildHouses(new int[][] {
                { 3, 4, 9, 10 },
                { 2, 5, 8, 11 },
                { 1, 6, 7, 12 } }));   // 9 (1 + 5 + 3)
    }

    public static int buildHouses(int[][] matrix) {
        int totalHouses = matrix.length;
        int totalColors = matrix[0].length;
        int[] dp = new int[totalColors];

        for (int house = 0; house < totalHouses; house++)
            dp = calc(dp, house, matrix, totalColors);

        return Arrays.stream(dp).min().orElse(-1);
    }

    private static int[] calc(int[] dp, int house, int[][] matrix, int totalColors) {
        int[] arr = new int[totalColors];

        for (int color = 0; color < totalColors; color++)
            arr[color] = getMin(dp, color) + matrix[house][color];

        return arr;
    }

    private static int getMin(int[] dp, int color) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < dp.length; i++)
            if (i != color)
                min = Math.min(min, dp[i]);

        return min;
    }
}
