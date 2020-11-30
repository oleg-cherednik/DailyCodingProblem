import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 28.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isRearrangePalindrome("carrace"));   // true
        System.out.println(isRearrangePalindrome("daily"));     // false
    }

    public static boolean isRearrangePalindrome(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

        int noPair = 0;

        for (int count : map.values())
            if (count % 2 != 0)
                noPair++;

        return noPair <= 1;
    }
}
