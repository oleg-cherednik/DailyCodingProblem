import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 01.04.2019
 */
public class Solution {

    public static void main(String... args) {
        String[] words = { "code", "edoc", "da", "d" };
        List<Pair> pairs = findAllPalindromePair(words);
        pairs.forEach(pair -> System.out.println("(" + pair.i + ", " + pair.j + ')'));
    }

    public static List<Pair> findAllPalindromePair(String[] words) {
        List<Pair> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j]))
                    res.add(new Pair(i, j));
                if (isPalindrome(words[j] + words[i]))
                    res.add(new Pair(j, i));
            }
        }

        return res;
    }

    private static boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--)
            if (word.charAt(i) != word.charAt(j))
                return false;

        return true;
    }

    public static final class Pair {
        private final int i;
        private final int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
