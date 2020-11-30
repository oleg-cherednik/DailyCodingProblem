import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 31.03.2019
 */
public class Solution {

    public static void main(String... args) {
        List<String> words = Arrays.asList("dog", "cat", "apple", "apricot", "fish");
        List<String> uniquePrefixes = getShortestUniquePrefix(words);
        uniquePrefixes.forEach(System.out::println);    // d, c, app, apr, f
    }

    public static List<String> getShortestUniquePrefix(List<String> words) {
        Map<String, Integer> prefixesAmount = new HashMap<>();

        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                int amount = prefixesAmount.getOrDefault(prefix, 0);
                prefixesAmount.put(prefix, amount + 1);
            }
        }

        List<String> uniquePrefixes = new ArrayList<>();

        for (String word : words) {
            int size = uniquePrefixes.size();

            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);

                if (prefixesAmount.get(prefix) == 1) {
                    uniquePrefixes.add(prefix);
                    break;
                }
            }

            if (uniquePrefixes.size() == size)
                throw new RuntimeException("Cannot get unique prefix for '" + word + '\'');
        }

        return uniquePrefixes;
    }
}
