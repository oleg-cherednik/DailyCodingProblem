/**
 * @author Oleg Cherednik
 * @since 11.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(exists(createBoard(), "ABCCED"));    // true
        System.out.println(exists(createBoard(), "SEE"));       // true
        System.out.println(exists(createBoard(), "ABCB"));      // false
    }

    private static char[][] createBoard() {
        return new char[][] {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }, };
    }

    public static boolean exists(char[][] board, String str) {
        boolean[][] visited = createVisited(board);

        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++)
                if (exists(board, row, col, str, 0, visited))
                    return true;

        return false;
    }

    private static boolean[][] createVisited(char[][] board) {
        boolean[][] visited = new boolean[board.length][];

        for (int row = 0; row < board.length; row++)
            visited[row] = new boolean[board[row].length];

        return visited;
    }

    @SuppressWarnings("AssignmentReplaceableWithOperatorAssignment")
    private static boolean exists(char[][] board, int row, int col, String str, int offs, boolean[][] visited) {
        if (offs >= str.length())
            return true;
        if (row < 0 || row >= board.length)
            return false;
        if (col < 0 || col >= board[row].length)
            return false;
        if (visited[row][col])
            return false;
        if (board[row][col] != str.charAt(offs))
            return false;

        visited[row][col] = true;

        boolean exists = exists(board, row, col + 1, str, offs + 1, visited);
        exists = exists || exists(board, row, col - 1, str, offs + 1, visited);
        exists = exists || exists(board, row + 1, col, str, offs + 1, visited);
        exists = exists || exists(board, row - 1, col, str, offs + 1, visited);

        visited[row][col] = false;
        return exists;
    }


}
