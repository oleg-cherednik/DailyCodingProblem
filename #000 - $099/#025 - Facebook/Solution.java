/**
 * @author Oleg Cherednik
 * @since 29.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isMatches("abcdefg", "ab*ef."));     // true
        System.out.println(isMatches("abcdefg", ".***.e*"));    // true
        System.out.println(isMatches("ray", "ra."));            // true
        System.out.println(isMatches("chats", "ra."));          // false
        System.out.println(isMatches("chats", "chat."));        // true
    }

    public static boolean isMatches(String str, String regexp) {
        return isMatches(str, 0, regexp, 0);
    }

    private static boolean isMatches(String str, int i, String regexp, int j) {
        if (j >= regexp.length())
            return i >= str.length();

        if (regexp.charAt(j) == '*') {
            if (j + 1 == regexp.length())
                return true;
            if (isMatches(str, i, regexp, j + 1))
                return true;

            for (int k = 1; k < str.length(); k++)
                if (isMatches(str, i + k, regexp, j + 1))
                    return true;
        } else if (str.charAt(i) == regexp.charAt(j) || regexp.charAt(j) == '.')
            return isMatches(str, i + 1, regexp, j + 1);

        return false;
    }
}
