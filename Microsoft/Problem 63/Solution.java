/**
 * @author Oleg Cherednik
 * @since 04.02.2019
 */
public class Solution {

    public static void main(String... args) {
        char[][] matrix = {
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}};
        System.out.println(isContainsWord(matrix, "FOAM")); // true
        System.out.println(isContainsWord(matrix, "MASS")); // true
        System.out.println(isContainsWord(matrix, "MASSS")); // false
    }

    public static boolean isContainsWord(char[][] matrix, String word) {
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)
                if (checkRow(matrix, row, col, word) || checkColumn(matrix, row, col, word))
                    return true;
        return false;
    }

    private static boolean checkColumn(char[][] matrix, int row, int col, String word) {
        if (col + word.length() > matrix[row].length)
            return false;

        for (int i = 0; i < matrix[row].length; i++)
            if (matrix[row][col + i] != word.charAt(i))
                return false;

        return true;
    }

    private static boolean checkRow(char[][] matrix, int row, int col, String word) {
        if (row + word.length() > matrix.length)
            return false;

        for (int i = 0; i < matrix.length; i++)
            if (matrix[row + i][col] != word.charAt(i))
                return false;

        return true;
    }
}
