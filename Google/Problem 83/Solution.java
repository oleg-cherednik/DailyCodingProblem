/**
 * @author Oleg Cherednik
 * @since 09.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Node root = invert(createTree());
    }

    private static Node createTree() {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;

        return a;
    }

    public static Node invert(Node node) {
        if (node == null)
            return null;

        Node left = node.left;
        Node right = node.right;
        node.right = invert(left);
        node.left = invert(right);

        return node;
    }

    private static final class Node {
        private final char data;
        private Node left;
        private Node right;

        public Node(char data) {
            this.data = data;
        }
    }

}
