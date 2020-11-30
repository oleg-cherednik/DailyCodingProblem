/**
 * @author Oleg Cherednik
 * @since 19.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getShortestSubstring("figehaeci", "aei"));
    }

    private static String getShortestSubstring(String str, String test) {
        String res = null;

        for (int i = 0, j = i; i < str.length() - test.length(); i++, j = i) {
            if (test.indexOf(str.charAt(i)) == -1)
                continue;

            for (int k = 0, pos; k < test.length(); k++)
                if (test.charAt(k) != str.charAt(i) && (pos = str.indexOf(test.charAt(k), i)) != -1)
                    j = Math.max(j, pos);

            if (res == null || res.length() > j + 1 - i)
                res = str.substring(i, j + 1);
        }

        return res;
    }
}
