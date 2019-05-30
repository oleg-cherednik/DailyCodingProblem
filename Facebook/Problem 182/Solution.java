/**
 * @author Oleg Cherednik
 * @since 31.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isMinimallyConnected(createMinimumConnected1()));  // false;
        System.out.println(isMinimallyConnected(createNotMinimumConnected1()));  // false;
        System.out.println(isMinimallyConnected(createNotMinimumConnected2()));  // false;
    }

    private static int[][] createMinimumConnected1() {
        return new int[][] {
                { 6, 2, 1, 5 },
                { 0 },
                { 0 },
                { 5, 4 },
                { 3 },
                { 3, 0 },
                { 0 } };
    }

    private static int[][] createNotMinimumConnected1() {
        return new int[][] {
                { 6, 2, 1, 5 },
                { 0 },
                { 0 },
                { 5, 4 },
                { 3 },
                { 3, 0 },
                { 0 },
                { 8 },
                { 7 },
                { 11, 10, 12 },
                { 9 },
                { 9 },
                { 9 } };
    }

    private static int[][] createNotMinimumConnected2() {
        return new int[][] {
                { 6, 2, 1, 5 },
                { 0 },
                { 0 },
                { 5, 4 },
                { 5, 6, 3 },
                { 3, 4, 0 },
                { 0, 4 },
                { 8 },
                { 7 },
                { 11, 10, 12 },
                { 9 },
                { 9, 12 },
                { 11, 9 } };
    }

    public static boolean isMinimallyConnected(int[][] adjacencyList) {
        boolean[] marked = new boolean[adjacencyList.length];

        if (!dfs(0, 0, adjacencyList, marked))
            return false;

        for (int i = 0; i < marked.length; i++)
            if (!marked[i])
                return false;

        return true;
    }

    private static boolean dfs(int v, int u, int[][] adjacencyList, boolean[] marked) {
        marked[v] = true;

        for (int w : adjacencyList[v]) {
            if (marked[w]) {
                if (w != u)
                    return false;
            } else if (!dfs(w, v, adjacencyList, marked))
                return false;
        }

        return true;
    }

}
