import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Oleg Cherednik
 * @since 29.05.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(split("racecarannakayak").toArray(new String[0])));  // ["racecar", "anna", "kayak"]
        System.out.println(Arrays.toString(split("abc").toArray(new String[0])));   // ["a", "b", "c"]
    }

    public static List<String> split(String str) {
        return Optional.ofNullable(findPalindromes(str, 0, str.length() - 1)).orElse(Collections.emptyList());
    }

    private static List<String> findPalindromes(String str, int left, int right) {
        for (int i = right; i >= left; i--) {
            if (!isPalindrome(str, left, i))
                continue;

            List<String> tail = i + 1 <= right ? findPalindromes(str, i + 1, right) : Collections.emptyList();

            if (tail == null)
                continue;

            List<String> res = new ArrayList<>(tail.size() + 1);
            res.add(str.substring(left, i + 1));
            res.addAll(tail);

            return res;
        }

        return null;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j)
            if (str.charAt(i++) != str.charAt(j--))
                return false;

        return true;
    }
}
