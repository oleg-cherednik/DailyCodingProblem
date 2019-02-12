/**
 * @author Oleg Cherednik
 * @since 12.12.2018
 */
public class Solution {

    public static void main(String... args) {
        Node t = new Node(3);
        Node root = createTree(t);
        System.out.println(isSubtreeEquals(root, t));   // true
    }

    private static Node createTree(Node t) {
        Node four = new Node(4);
        four.left = new Node(7);

        Node two = new Node(2);
        two.right = four;

        t.left = new Node(5);
        t.right = new Node(6);

        Node root = new Node(1);
        root.left = two;
        root.right = t;

        return root;
    }

    public static boolean isSubtreeEquals(Node s, Node t) {
        String strS = serialize(s);
        String strT = serialize(t);
        return strS.contains(strT);
    }

    private static String serialize(Node root) {
        return dfs(root, new StringBuilder()).toString();
    }

    private static StringBuilder dfs(Node node, StringBuilder buf) {
        if (node != null) {
            buf.append(node.data);

            buf.append('(');
            dfs(node.left, buf);
            buf.append(')');
            buf.append('(');
            dfs(node.right, buf);
            buf.append(')');
        }

        return buf;
    }

    private static final class Node {
        private final int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}
