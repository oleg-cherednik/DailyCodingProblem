/**
 * @author Oleg Cherednik
 * @since 10.12.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(reverseWords("hello world here"));
        System.out.println(new String(reverseWords("hello world here".toCharArray())));
    }

    public static String reverseWords(String str) {
        if (str == null || str.isEmpty())
            return str;

        String[] words = str.split("\\s+");
        StringBuilder buf = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (buf.length() > 0)
                buf.append(' ');
            buf.append(words[i]);
        }

        return buf.toString();
    }

    public static char[] reverseWords(char... arr) {
        if (arr == null || arr.length == 0)
            return arr;

        reverse(arr, 0, arr.length);

        int from = 0;
        int to = 0;

        while (to < arr.length) {
            while (from < arr.length && arr[from] == ' ') {
                from++;
                to++;
            }

            if (from == arr.length)
                break;

            while (to < arr.length && arr[to] != ' ')
                to++;

            reverse(arr, from, to);
            from = to;
        }

        return arr;
    }

    private static void reverse(char[] arr, int from, int to) {
        for (int i = from, j = to - 1; i < j; i++, j--)
            swap(arr, i, j);
    }

    private static void swap(char[] arr, int i, int j) {
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}
