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
        int[] line = new int[board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < line.length; col++) {
                if (board[row][col] == 1)
                    continue;

                int count = 0;

                if (row == 0 && col == 0)
                    count = 1;
                else {
                    if (col > 0 && board[row][col - 1] == 0)
                        count += line[col - 1];
                    if (row > 0 && board[row - 1][col] == 0)
                        count += line[col];
                }

                line[col] = count;
            }
        }

        return line[line.length - 1];
    }

}
