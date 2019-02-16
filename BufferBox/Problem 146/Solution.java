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

        prune(node.left);
        prune(node.right);

        if (canPrune(node.left))
            node.left = null;
        if (canPrune(node.right))
            node.right = null;

        return node;
    }

    private static boolean canPrune(Node node) {
        if (node == null)
            return true;
        if (node.data == 1)
            return false;
        return canPrune(node.left) && canPrune(node.right);
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
