import java.util.function.BiFunction;

/**
 * @author Oleg Cherednik
 * @since 18.12.2018
 */
public class Solution {

    public static void main(String... args) {
        int[][] matrix =
                {
                        { 0, 3, 1, 1 },
                        { 2, 0, 0, 4 },
                        { 1, 5, 3, 1 }
                };
        System.out.println(maxCoins(matrix));
    }

    public static int maxCoins(int[][] matrix) {
        if (matrix == null)
            return 0;

        BiFunction<Integer, Integer, Integer> get =
                (row, col) -> row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length ? 0 : matrix[row][col];
        int width = matrix[0].length;

        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < width; col++)
                matrix[row][col] += Math.max(get.apply(row - 1, col), get.apply(row, col - 1));

        return matrix[matrix.length - 1][width - 1];
    }

}
