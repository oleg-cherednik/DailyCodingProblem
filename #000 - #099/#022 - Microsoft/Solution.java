import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 31.01.2019
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(splitWords(words("quick", "brown", "the", "fox"), "thequickbrownfox"));
        System.out.println(splitWords(words("bed", "bath", "bedbath", "and", "beyond"), "bedbathandbeyond"));
        System.out.println(splitWords(words("the", "theremin"), "theremin"));
        System.out.println(splitWords(words("a", "aa", "aaa", "aaaa", "aaaaa"), "aaaaab"));
    }

    private static Set<String> words(String... words) {
        return Arrays.stream(words).collect(Collectors.toSet());
    }

    public static List<String> splitWords(Set<String> words, String str) {
        Deque<String> queue = new LinkedList<>();
        splitWords(queue, words, str, 0);
        return queue.isEmpty() ? null : new ArrayList<>(queue);
    }

    private static boolean splitWords(Deque<String> queue, Set<String> words, String str, int offs) {
        if (offs >= str.length())
            return true;

        for (String word : words) {
            if (!str.startsWith(word, offs))
                continue;

            queue.addLast(word);

            if (splitWords(queue, words, str, offs + word.length()))
                return true;

            queue.removeLast();
        }

        return false;
    }

}
