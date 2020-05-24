/**
 * @author Oleg Cherednik
 * @since 02.06.2019
 */
public class Solution {

    public static void main(String... args) {
        int[][] matrix = {
                { 1, 3, 7, 10, 15, 20 },
                { 2, 6, 9, 14, 22, 25 },
                { 3, 8, 10, 15, 25, 30 },
                { 10, 11, 12, 23, 30, 35 },
                { 20, 25, 30, 35, 40, 45 } };
        System.out.println(count(matrix, 1, 1, 3, 3));
    }

    public static int count(int[][] matrix, int i1, int j1, int i2, int j2) {
        int res = 0;
        int low = matrix[i1][j1];
        int high = matrix[i2][j2];

        for (int[] row : matrix) {
            if (row[0] > high || row[row.length - 1] < low)
                res += row.length;
            else if (row[0] >= low && row[row.length - 1] <= high)
                continue;

            for (int i = 0; i < row.length && row[i] < low; i++)
                res++;
            for (int i = row.length - 1; i >= 0 && row[i] > high; i--)
                res++;
        }

        return res;
    }
}
