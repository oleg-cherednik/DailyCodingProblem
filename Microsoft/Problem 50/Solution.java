/**
 * @author Oleg Cherednik
 * @since 31.10.2018
 */
public class Solution {

    public static String evaulate(Node root) {
        String expr = dfs(root, new StringBuilder()).toString();
        Object res = null;    // TODO evaluate JavaScript
        return String.valueOf(res);
    }

    private static StringBuilder dfs(Node node, StringBuilder buf) {
        if (node == null || (node.left == null && node.right == null))
            return buf;

        buf.append('(');
        dfs(node.left, buf);
        buf.append(' ').append(node.ch).append(' ');
        dfs(node.right, buf);
        buf.append(')');

        return buf;
    }

    public static final class Node {

        private final char ch;
        private Node left;
        private Node right;

        public Node(char ch) {
            this.ch = ch;
        }
    }

    public static void main(String... args) {

    }
}
