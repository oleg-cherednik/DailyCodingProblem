import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 01.02.2019
 */
public class Solution {

    public static void main(String... args) {
        justify(Arrays.asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"), 16).forEach(System.out::println);
    }

    public static List<String> justify(List<String> words, int k) {
        List<String> lines = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0;

        for (String word : words) {
            if (length + line.size() + line.size() > k) {
                lines.add(justify(line, length, k));
                line.clear();
                length = 0;
            }

            line.add(word);
            length += word.length();
        }

        if (!line.isEmpty())
            lines.add(justify(line, length, k));

        return lines;
    }

    private static String justify(List<String> words, int length, int k) {
        int[] spaces = new int[words.size() - 1];

        while (length < k) {
            for (int i = 0; i < spaces.length && length < k; i++) {
                spaces[i]++;
                length++;
            }
        }

        int i = 0;
        StringBuilder buf = new StringBuilder();

        for (String word : words) {
            buf.append(word);

            if (i < spaces.length) {
                for (int j = 0; j < spaces[i]; j++)
                    buf.append(' ');

                i++;
            }
        }

        return buf.toString();
    }

}
