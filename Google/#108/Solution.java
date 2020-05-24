/**
 * @author Oleg Cherednik
 * @since 11.12.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isShifted("abcde", "cdeab"));    // true
        System.out.println(isShifted("abc", "acb"));        // false
    }

    public static boolean isShifted(String one, String two) {
        if (one.length() != two.length())
            return false;
        if (one.equals(two))
            return true;

        for (int i = 0; i <= one.length(); i++)
            if ((one = shiftLeft(one)).equals(two))
                return true;

        return false;
    }

    private static String shiftLeft(String str) {
        return str.substring(1) + str.charAt(0);
    }
}

