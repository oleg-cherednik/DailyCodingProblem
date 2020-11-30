/**
 * @author Oleg Cherednik
 * @since 10.12.2018
 */
public class Solution {

    public static void main(String... args) {
        String str = "hello world here";
        System.out.println(str);
        System.out.println(reverseWords(str));
        System.out.println(new String(reverseWords(str.toCharArray())));
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
        swapArr(arr, 0, arr.length - 1);

        for (int i = 0, j = 0; j < arr.length; j++) {
            if (arr[j] == ' ') {
                if (arr[i] != ' ')
                    swapArr(arr, i, j - 1);

                i = j;
            } else {
                if (arr[i] == ' ')
                    i = j;
                if (j == arr.length - 1 && arr[i] != ' ')
                    swapArr(arr, i, j);
            }
        }

        return arr;
    }

    private static void swapArr(char[] arr, int i, int j) {
        while (i < j)
            swap(arr, i++, j--);
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
