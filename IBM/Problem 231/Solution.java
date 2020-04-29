/**
 * @author Oleg Cherednik
 * @since 08.03.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(rearrange("aaabbc"));    // ababac
        System.out.println(rearrange("a"));         // a
        System.out.println(rearrange("aaab"));      // None
        System.out.println(rearrange(""));          // None
    }

    public static String rearrange(String str) {
        char[] arr = groupLetters(str);

        if (arr == null)
            return "None";

        for (int i = 1, lst = arr.length - 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1])
                continue;
            if (arr[i] == arr[lst])
                return "None";
            arr[i] = arr[lst];
            arr[lst] = arr[i - 1];
        }

        return new String(arr);
    }

    private static char[] groupLetters(String str) {
        if (str == null || str.isEmpty())
            return null;
        if (str.length() == 1)
            return str.toCharArray();

        int[] counts = new int[26];
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++)
            counts[str.charAt(i) - 'a']++;

        char[] arr = new char[str.length()];

        for (int i = 0, j = 0; i < counts.length; i++)
            for (int k = 0; k < counts[i]; k++)
                arr[j++] = (char)('a' + i);

        return arr;
    }

}
