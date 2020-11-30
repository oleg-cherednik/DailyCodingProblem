/**
 * @author Oleg Cherednik
 * @since 14.02.2019
 */
public class Solution {

    public static void main(String... args) {
        int[][] matrix = {
                {1, 1, 0, 0},
                {1, 0, 1, 1},
                {1, 0, 1, 1},
                {0, 1, 0, 0}};
        System.out.println(getLargestAreaSet(matrix));   // 4
    }

    public static int getLargestAreaSet(int[][] matrix) {
        int maxArea = 0;
        int[] cache = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0)
                    cache[col] = 0;
                else
                    cache[col]++;
            }

            maxArea = Math.max(maxArea, inferArea(cache));
        }

        return maxArea;
    }

    private static int inferArea(int[] cache) {
        int area = 0;

        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == 0)
                continue;

            int min = cache[i];

            for (int j = i; j < cache.length && cache[j] != 0; j++)
                area = Math.max(area, Math.min(min, cache[j]) * (j - i + 1));
        }

        return area;
    }
}
