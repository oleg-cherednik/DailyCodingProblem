/**
 * @author Oleg Cherednik
 * @since 14.02.2019
 */
public class Solution {

    public static void main(String... args) {
        int[][] matrix = {
                { 1, 1, 0, 0 },
                { 1, 0, 1, 1 },
                { 1, 0, 1, 1 },
                { 0, 1, 0, 0 } };
        System.out.println(getLargestAreaSet(matrix));   // 4
    }

    public static int getLargestAreaSet(int[][] matrix) {
        int max = 0;
        int[] arr = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                if (matrix[row][col] == 0)
                    arr[col] = 0;
                else {
                    int tmp = get(arr, col - 1) + 1;

                    if (arr[col] == 0)
                        arr[col] = tmp;
                    else
                        arr[col] *= 2;
                }

                max = Math.max(max, arr[col]);
            }
        }

        return max;
    }

    private static int get(int[] arr, int col) {
        return col < 0 || col >= arr.length ? 0 : arr[col];
    }


}
