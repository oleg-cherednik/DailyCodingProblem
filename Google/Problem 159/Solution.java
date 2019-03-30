import java.util.HashSet;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 20.03.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getFirstRecurringChar("acbbac"));    // b
        System.out.println(getFirstRecurringChar("abcdef"));    // null
    }

    public static String getFirstRecurringChar(String str) {
        Set<Character> letters = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (letters.contains(ch))
                return String.valueOf(ch);

            letters.add(ch);
        }

        return null;
    }

}
