import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 20.01.2019
 */
public class Solution {

    public static void main(String... args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addWords(Arrays.asList("dog", "deer", "deal"));
        dictionary.getWords("de").forEach(System.out::println);
    }

    private static final class Dictionary {

        private final Node root = new Node('\0');

        public void addWords(Collection<String> words) {
            Optional.ofNullable(words).orElse(Collections.emptySet()).forEach(root::addWord);
        }

        public Set<String> getWords(String prefix) {
            return getWords(prefix, findLastNode(prefix != null ? prefix.trim().toLowerCase() : null, 0, root));
        }

        private static Node findLastNode(String prefix, int i, Node node) {
            while (true) {
                if (node == null)
                    return null;
                if (i == prefix.length())
                    return node;
                node = node.getChild(prefix.charAt(i));
                i++;
            }
        }

        private static Set<String> getWords(String prefix, Node node) {
            if (node == null)
                return Collections.emptySet();
            if (!node.hasChildren())
                return Collections.singleton(prefix);
            return collectWords(prefix, node, new TreeSet<>());
        }

        private static Set<String> collectWords(String prefix, Node node, Set<String> words) {
            if (node == null)
                return words;
            if (node.end)
                words.add(prefix);
            if (node.hasChildren())
                for (Node child : node.children)
                    if (child != null)
                        collectWords(prefix + child.ch, child, words);
            return words;
        }

        private static final class Node {

            private final char ch;
            private Node[] children;
            private boolean end;

            public Node(char ch) {
                this.ch = ch;
            }

            public boolean hasChildren() {
                return children != null;
            }

            public Node getChild(char ch) {
                return hasChildren() ? children[ch - 'a'] : null;
            }

            public void addWord(String word) {
                addWord(word != null ? word.trim().toLowerCase() : null, 0, this);
            }

            private Node addChild(char ch) {
                children = children != null ? children : new Node['z' - 'a' + 1];
                children[ch - 'a'] = children[ch - 'a'] != null ? children[ch - 'a'] : new Node(ch);
                return children[ch - 'a'];
            }

            private static void addWord(String word, int i, Node node) {
                if (word == null)
                    return;
                if (i == word.length())
                    node.end = true;
                else
                    addWord(word, i + 1, node.addChild(word.charAt(i)));
            }
        }
    }
}
