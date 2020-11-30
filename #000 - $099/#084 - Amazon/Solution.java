/**
 * @author Oleg Cherednik
 * @since 09.02.2019
 */
public class Solution {

    public static void main(String... args) {
        int[][] matrix = {
                { 1, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 1, 1, 0, 0, 1 } };
        System.out.println(findIslandsAmount(matrix));
    }

    public static int findIslandsAmount(int[][] matrix) {
        int[][] visited = copyMatrix(matrix);
        int id = 1;

        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)
                if (dfs(visited, row, col, id))
                    id++;

        return id - 1;
    }

    private static boolean dfs(int[][] visited, int row, int col, int id) {
        if (row < 0 || row >= visited.length)
            return false;
        if (col < 0 || col >= visited[row].length)
            return false;
        if (visited[row][col] != -1)
            return false;

        visited[row][col] = id;

        dfs(visited, row, col + 1, id);
        dfs(visited, row, col - 1, id);
        dfs(visited, row + 1, col, id);
        dfs(visited, row - 1, col, id);

        return true;
    }

    private static int[][] copyMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][];

        for (int row = 0; row < matrix.length; row++) {
            res[row] = new int[matrix[row].length];

            for (int col = 0; col < matrix[row].length; col++)
                res[row][col] = matrix[row][col] != 0 ? -1 : 0;
        }

        return res;
    }

}
