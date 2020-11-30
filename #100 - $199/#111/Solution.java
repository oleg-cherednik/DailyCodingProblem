import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 12.12.2018
 */
public class Solution {

    public static void main(String... args) {
        int[] indices = findAllIndices("ab", "abxaba").stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(indices));   // 0, 3, 4
    }

    public static Set<Integer> findAllIndices(String word, String str) {
        Map<Character, Integer> histogram = buildHistogram(word);
        Set<Integer> indices = new TreeSet<>();

        for (int i = 0; i <= str.length() - word.length(); i++)
            if (isHistogramMatches(histogram, str, i, word.length()))
                indices.add(i);

        return indices;
    }

    private static boolean isHistogramMatches(Map<Character, Integer> expected, String word, int offs, int length) {
        if (!expected.containsKey(word.charAt(offs)))
            return false;

        Map<Character, Integer> actual = new HashMap<>(expected);

        for (int j = 0; j < length; j++) {
            char ch = word.charAt(offs + j);

            if (!actual.containsKey(ch))
                return false;
            if (actual.get(ch) == 1)
                actual.remove(ch);
            else
                actual.put(ch, actual.get(ch) - 1);
        }

        return actual.isEmpty();
    }

    private static Map<Character, Integer> buildHistogram(String str) {
        Map<Character, Integer> histogram = new HashMap<>();

        for (int i = 0; i < str.length(); i++)
            histogram.put(str.charAt(i), histogram.getOrDefault(str.charAt(i), 0) + 1);

        return histogram;
    }
}

