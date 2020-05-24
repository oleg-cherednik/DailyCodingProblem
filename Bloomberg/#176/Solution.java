/**
 * @author Oleg Cherednik
 * @since 28.05.2019
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(exists("abc", "bcd"));   // true
        System.out.println(exists("foo", "bar"));    // false
    }

    public static boolean exists(String one, String two) {
        if (one.length() != two.length())
            return false;

        char[] arr = new char[26];

        for (int i = 0; i < one.length(); i++) {
            char chOne = one.charAt(i);
            char chTwo = two.charAt(i);

            if (arr[chOne - 'a'] == '\0')
                arr[chOne - 'a'] = chTwo;

            if (arr[chOne - 'a'] != chTwo)
                return false;
        }

        return true;
    }

}
