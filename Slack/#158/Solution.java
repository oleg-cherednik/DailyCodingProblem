/**
 * @author Oleg Cherednik
 * @since 28.02.2019
 */
public class Solution {

    public static void main(String[] args) {
        int[][] board = {
                { 0, 0, 1 },
                { 0, 0, 1 },
                { 1, 0, 0 } };
        System.out.println(findWaysAmount(board));  // 2
    }

    public static int findWaysAmount(int[][] board) {
        final int width = board[0].length;
        final int height = board.length;

        int[] arr = new int[width];
        arr[0] = 1;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (board[row][col] == 1)
                    arr[col] = 0;
                else if (col > 0)
                    arr[col] += arr[col - 1];
            }
        }

        return arr[width - 1];
    }

}
