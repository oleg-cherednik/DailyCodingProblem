import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 09.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(String.join(" ", getWords(23)));
    }

    public static Set<String> getWords(int num) {
        String digits = String.valueOf(num);
        Set<String> words = new TreeSet<>();

        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);

            Set<String> prvWords = words.isEmpty() ? Collections.emptySet() : new HashSet<>(words);
            words.clear();

            for (char letter : getLetters(digit)) {
                if (prvWords.isEmpty())
                    words.add(String.valueOf(letter));
                else
                    for (String word : prvWords)
                        words.add(word + letter);
            }
        }

        return words;
    }

    private static char[] getLetters(char digit) {
        return MAP.getOrDefault(digit, EMPTY);
    }

    private static final char[] EMPTY = new char[0];
    private static final Map<Character, char[]> MAP = new HashMap<>();

    static {
        MAP.put('2', new char[] { 'a', 'b', 'c' });
        MAP.put('3', new char[] { 'd', 'e', 'f' });
        MAP.put('4', new char[] { 'g', 'h', 'i' });
        MAP.put('5', new char[] { 'j', 'k', 'l' });
        MAP.put('6', new char[] { 'm', 'n', 'o' });
        MAP.put('7', new char[] { 'p', 'q', 'r', 's' });
        MAP.put('8', new char[] { 't', 'u', 'v' });
        MAP.put('9', new char[] { 'w', 'x', 'y', 'z' });
    }
}
