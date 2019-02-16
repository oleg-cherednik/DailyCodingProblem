import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Oleg Cherednik
 * @since 16.02.2019
 */
public class Solution {
    public static void main(String[] args) {
        char[][] image = {
                { 'B', 'B', 'W' },
                { 'W', 'W', 'W' },
                { 'W', 'W', 'W' },
                { 'B', 'W', 'B' } };
        print(image);
        replaceColor(image, 'G', 2, 2);
        print(image);
    }

    private static void print(char[][] image) {
        for (char[] row : image)
            System.out.println(IntStream.range(0, row.length)
                                        .mapToObj(col -> String.valueOf(row[col]))
                                        .collect(Collectors.joining(" ")));
        System.out.println();
    }

    public static void replaceColor(char[][] image, char dest, int row, int col) {
        if (image[row][col] != dest)
            dfs(image, image[row][col], dest, row, col);
    }

    private static void dfs(char[][] image, char src, char dest, int row, int col) {
        if (row < 0 || row >= image.length)
            return;
        if (col < 0 || col >= image[row].length)
            return;
        if (image[row][col] != src)
            return;

        image[row][col] = dest;
        dfs(image, src, dest, row, col + 1);
        dfs(image, src, dest, row, col - 1);
        dfs(image, src, dest, row + 1, col);
        dfs(image, src, dest, row - 1, col);
    }

}
