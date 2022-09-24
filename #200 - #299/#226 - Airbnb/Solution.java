import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 24.09.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(getSortedLetters("xww", "wxyz", "wxyw", "ywx", "ywz"))); // x,z,w,y
    }

    private static char[] getSortedLetters(String... words) {
        Map<Character, List<Character>> graph = buildGraph(words);
        Deque<Character> stack = topologicalSort(graph);

        char[] letters = new char[stack.size()];

        for (int i = 0; i < letters.length; i++)
            letters[i] = stack.pop();

        return letters;
    }

    private static Map<Character, List<Character>> buildGraph(String... words) {
        Map<Character, List<Character>> map = new HashMap<>();
        String prvWord = null;

        for (String word : words) {
            boolean checkLetter = prvWord != null;

            for (int i = 0; i < word.length(); i++) {
                if (!map.containsKey(word.charAt(i)))
                    map.put(word.charAt(i), new ArrayList<>());

                if (checkLetter) {
                    if (i >= prvWord.length())
                        checkLetter = false;
                    else if (word.charAt(i) != prvWord.charAt(i)) {
                        map.get(prvWord.charAt(i)).add(word.charAt(i));
                        checkLetter = false;
                    }
                }
            }

            prvWord = word;
        }

        return map;
    }

    private static Deque<Character> topologicalSort(Map<Character, List<Character>> graph) {
        Deque<Character> stack = new LinkedList<>();
        Set<Character> letters = graph.keySet();
        Map<Character, Boolean> visited = new HashMap<>();

        for (char letter : letters) {
            dfs(graph, letter, visited, stack);
        }

        return stack;
    }

    private static void dfs(Map<Character, List<Character>> graph, char letter, Map<Character, Boolean> visited, Deque<Character> stack) {
        if (visited.getOrDefault(letter, false))
            return;

        visited.put(letter, true);

        for (Character nextLetter : graph.get(letter)) {
            dfs(graph, nextLetter, visited, stack);
        }

        stack.push(letter);
    }

}
