import java.util.Arrays;

/**
 * @author Oleg Cherednik
 * @since 01.04.2019
 */
public class Solution {

    public static void main(String... args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        rotateClockwise(matrix);

        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));   // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
    }

    public static void rotateClockwise(int[][] matrix) {
        final int width = matrix[0].length;
        final int height = matrix.length;

        // flip horizontally
        for (int row = 0; row < height; row++)
            for (int col1 = 0, col2 = width - 1; col1 < col2; col1++, col2--)
                swap(matrix, row, col1, row, col2);

        // flip diagonally
        for (int i = 0; i < width - 1; i++) {
            int row1 = i;
            int row2 = height - 1;
            int col1 = 0;
            int col2 = width - i - 1;

            while (row1 >= 0) {
                swap(matrix, row1--, col1++, row2--, col2++);
            }
        }
    }

    private static void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int tmp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = tmp;
    }

}
