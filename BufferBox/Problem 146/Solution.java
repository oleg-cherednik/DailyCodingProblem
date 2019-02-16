/**
 * @author Oleg Cherednik
 * @since 16.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Node root = createTree();
        root = prune(root);
    }

    private static Node createTree() {
        Node one = new Node(1);
        one.left = new Node(0);
        one.right = new Node(0);

        Node two = new Node(0);
        two.left = one;
        two.right = new Node(0);

        Node root = new Node(0);
        root.left = new Node(1);
        root.right = two;

        return root;
    }

    public static Node prune(Node node) {
        if (node == null)
            return null;

        node.left = prune(node.left);
        node.right = prune(node.right);
        return node.data == 0 && node.left == null && node.right == null ? null : node;
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
